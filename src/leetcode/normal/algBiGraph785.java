package leetcode.normal;

public class algBiGraph785 {

    // 是否访问过
    boolean[] visited;

    // 是否是二分图
    boolean result = true;

    // 染色相邻的节点不能是同一种颜色，否则不是二分图
    boolean[] color;


    public boolean isBipartite(int[][] graph) {

        int size = graph.length;
        visited = new boolean[size];
        color = new boolean[size];

        for (int i = 0; i < size; i++) {
            // 没有访问过 去访问
            if (!visited[i]){
                traversal(graph, i);
            }

            if (!result) {
                return false;
            }
        }

        return result;
    }

    private void traversal(int[][] graph, int cur) {

        if (!result)
            return;

        // 标记为访问过
        visited[cur] = true;

        for (int node : graph[cur]) {
            if (!visited[node]) {
                // 颜色取反
                color[node] = !color[cur];
                // 接着访问
                traversal(graph, node);
            }else{
                // 如果访问了就比较
                if (color[node] == color[cur]){
                    result = false;
                }
            }
        }

    }
}
