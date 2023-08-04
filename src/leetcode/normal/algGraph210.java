package leetcode.normal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class algGraph210 {

    // 使用DFS来完成拓扑排序 图的后序遍历
    // DFS没办法知道谁在最前面 但是一定能找到在最后面的节点
    List<Integer> path;

    boolean[] visited,onPath;
    List<Integer>[] graph;
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        path = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            traversal(i);
            if (hasCycle) return new int[]{};
        }

        Collections.reverse(path);

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = path.get(i);
        }

        return result;
    }

    private void traversal(int node) {

        if (onPath[node]){
            hasCycle = true;
        }

        if (hasCycle || visited[node]) {
            return;
        }

        visited[node] = true;
        onPath[node] = true;

        for (int cur : graph[node]) {
            traversal(cur);
        }

        // 后序位置添加
        path.add(node);
        onPath[node] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        return graph;
    }
}
