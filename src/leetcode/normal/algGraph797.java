package leetcode.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class algGraph797 {


    // 用于存放结果
    List<List<Integer>> result;


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traversal(graph, 0, path);
        return result;

    }

    private void traversal(int[][] graph, int cur, LinkedList<Integer> path) {

        path.add(cur);
        if (cur == graph.length - 1) {
            // 这里必须要添加一个新开辟空间的path 不然传入对象引用会发生改变
            result.add(new LinkedList<>(path));
            // 添加后还需要取出来
            path.removeLast();
            return;
        }

        for (int i = 0; i < graph[cur].length; i++) {
            traversal(graph, graph[cur][i], path);
        }

        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = new algGraph797().allPathsSourceTarget(graph);
        System.out.println(lists);
    }
}
