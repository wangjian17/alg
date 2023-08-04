package leetcode.normal;

import java.util.LinkedList;
import java.util.List;

public class algGraph207 {


    // 防止重复判断
    boolean[] visited;
    boolean[] onPath;

    // 是否有环
    boolean hasCycle = false;


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        // DFS访问所有节点
        for (int i = 0; i < numCourses; i++) {
            traversal(i, graph);
            // 剪枝
            if (hasCycle) return false;
        }

        return !hasCycle;

    }

    private void traversal(int i,  List<Integer>[] graph) {

        // 路径中存在，表示有环
        if (onPath[i]){
            hasCycle = true;
        }

        if (hasCycle || visited[i]) {
            return;
        }

        visited[i] = true;
        onPath[i] = true;

        for (int node : graph[i]) {
            traversal(node, graph);
        }
        onPath[i] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

        // 新建数组
        LinkedList<Integer>[] graph = new LinkedList[numCourses];

        // 同时需要新建每一个链表
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }


        return graph;
    }
}
