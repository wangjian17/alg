package leetcode.normal;

import java.util.LinkedList;
import java.util.List;

public class algBiGraph886 {

    boolean result;
    List<Integer>[] graph;

    boolean[] visited;
    boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {

        result = true;
        visited = new boolean[n];
        color = new boolean[n];
        buildGraph(n, dislikes);

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                traversal(i);

            if (!result){
                return false;
            }
        }

        return true;
    }

    private void traversal(int cur) {

        if (!result) return;
        visited[cur] = true;

        for (Integer neighbour : graph[cur]) {
            if (!visited[neighbour]) {
                color[neighbour] = !color[cur];
                traversal(neighbour);
            }else{
                if (color[neighbour] == color[cur]) {
                    result = false;
                    return;
                }
            }
        }
    }

    private void buildGraph(int n, int[][] dislikes) {

        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] dislike : dislikes) {
            int first = dislike[0] - 1;
            int second = dislike[1] - 1;

            // 无向图
            graph[first].add(second);
            graph[second].add(first);
        }
    }


}
