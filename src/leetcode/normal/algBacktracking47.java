package leetcode.normal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class algBacktracking47 {

    List<List<Integer>> result;
    LinkedList<Integer> path;

    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {

        // 因为有重复， 先排序
        Arrays.sort(nums);

        result = new LinkedList<>();
        path = new LinkedList<>();
        visit = new boolean[nums.length];

        backtracking(nums);

        return result;
    }

    private void backtracking(int[] nums) {

        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])){
                continue;
            }

            if (!visit[i]) {
                visit[i] = true;
                path.add(nums[i]);

                backtracking(nums);

                path.removeLast();
                visit[i] = false;
            }
        }

    }

}
