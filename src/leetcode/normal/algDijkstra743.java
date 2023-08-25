package leetcode.normal;

import java.util.*;

public class algDijkstra743 {

    class Node{

        int id;
        int minDistance;

        public Node(int id, int minDistance) {
            this.id = id;
            this.minDistance = minDistance;
        }
    }

    LinkedList<Integer>[] graph;
    int[][] weights;

    int[] minDistances;

    public int networkDelayTime(int[][] times, int n, int k) {

        graph = new LinkedList[n];

        weights = new int[n][n];

        minDistances = new int[n];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[k - 1] = 0;


        // 生成图
        buildGraph(times);

        // dijkstra算法
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.minDistance - o2.minDistance;
            }
        });

        queue.add(new Node(k - 1, 0));

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            int id = node.id;

            for (int next : graph[id]) {
                int minDistance = node.minDistance + weights[id][next];

                if (minDistance < minDistances[next]) {
                    queue.add(new Node(next, minDistance));
                    minDistances[next] = minDistance;
                }
            }

        }

        int result = 0;
        for (int minDistance : minDistances) {
            result = Math.max(minDistance, result);
        }

        return result == Integer.MAX_VALUE ? -1: result;
    }

    private void buildGraph(int[][] times) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] time : times) {
            int from = time[0] - 1;
            int to = time[1] - 1;
            int weight = time[2];

            graph[from].add(to);
            weights[from][to] = weight;
        }
    }


}
