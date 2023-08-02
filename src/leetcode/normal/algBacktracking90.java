package leetcode.normal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class algBacktracking90 {

    List<List<Integer>> result;
    LinkedList<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // 元素重复 因此先排序 后去重
        Arrays.sort(nums);

        result = new LinkedList<>();
        path = new LinkedList<>();

        backtracking(nums, 0);

        return result;
    }

    private void backtracking(int[] nums, int start) {

        result.add(new LinkedList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 树枝去重
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            }

            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
