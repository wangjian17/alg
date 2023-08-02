package leetcode.normal;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class algBacktracking78 {

    List<List<Integer>> result;
    LinkedList<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {

        result = new LinkedList<>();
        path = new LinkedList<>();

        backtracking(nums, 0);

        return result;

    }

    private void backtracking(int[] nums, int start) {

        // 直接添加
        result.add(new LinkedList<>(path));

        // 开始遍历
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i +1);
            path.removeLast();
        }
    }
}
