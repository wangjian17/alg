package leetcode.normal;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class algDijkstra1514 {

    class Node{
        int id;

        double maxProbability;

        public Node(int id, double maxProbability) {
            this.id = id;
            this.maxProbability = maxProbability;
        }
    }

    LinkedList<double[]>[] graph;
    double[] maxProbabilities;


    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        // 初始化
        init(n, edges, succProb);

        maxProbabilities[start_node] = 1;

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.maxProbability < o2.maxProbability){
                    return 1;
                } else if (o1.maxProbability > o2.maxProbability) {
                    return -1;
                }
                return 0;
            }
        });
        queue.add(new Node(start_node, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int id = node.id;

            if (id == end_node){
                return maxProbabilities[end_node];
            }

            for (double[] next : graph[id]) {

                double p = node.maxProbability * next[1];
                int nextId = (int)next[0];
                if (p > maxProbabilities[nextId]) {
                    queue.add(new Node(nextId, p));
                    maxProbabilities[nextId] = p;
                }
            }
        }
        return maxProbabilities[end_node];
    }

    private void init(int n, int[][] edges, double[] succProb) {

        graph = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        maxProbabilities = new double[n];


        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            graph[from].add(new double[]{to, succProb[i]});
            graph[to].add(new double[]{from, succProb[i]});


        }

    }
}
