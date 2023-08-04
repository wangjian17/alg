package leetcode.normal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class algBFS210 {

    // 使用BFS来实现拓扑排序
    boolean[] visited, onPath;
    int[] result;

    List<Integer>[] graph;

    int[] inDegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        inDegree = new int[numCourses];
        result = new int[numCourses];

        buildGraph(numCourses, prerequisites);

        // 使用队列放入度为0的节点
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 判断是否遍历完所有节点 如果没有表示存在环
        int count = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // 取出节点
                Integer node = queue.poll();
                // 将关联的入度减少1
                for (Integer integer : graph[node]) {
                    if (--inDegree[integer] == 0) {
                        queue.add(integer);
                    }
                }

                // 放入结果
                result[count++] = node;
            }
        }

        if (count != numCourses) {
            // 存在环
            return new int[]{};
        }

        return result;
    }

    private void buildGraph(int numCourses, int[][] prerequisites) {

        graph = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];

            graph[from].add(to);
            ++inDegree[to];
        }

    }
}
