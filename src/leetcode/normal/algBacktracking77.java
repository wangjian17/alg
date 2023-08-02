package leetcode.normal;

import java.util.LinkedList;
import java.util.List;

public class algBacktracking77 {

    List<List<Integer>> result;
    LinkedList<Integer> path;


    public List<List<Integer>> combine(int n, int k) {
        // 不包含重复元素 不可以复选
        result = new LinkedList<>();
        path = new LinkedList<>();

        backTracking(n, k, 1);

        return result;
    }

    private void backTracking(int n, int k, int start) {

        // 判断成功
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }

    }

}
