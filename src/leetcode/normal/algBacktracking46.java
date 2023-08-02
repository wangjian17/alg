package leetcode.normal;

import java.util.LinkedList;
import java.util.List;

public class algBacktracking46 {

    List<List<Integer>> result;

    boolean[] visit;

    LinkedList<Integer> path;

    public List<List<Integer>> permute(int[] nums) {

        result = new LinkedList<>();
        visit = new boolean[nums.length];
        path = new LinkedList<>();

        backtracking(nums);

        return result;
    }

    private void backtracking(int[] nums) {

        // 成功条件
        if (path.size() == nums.length) {
            // 添加
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i <nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                path.add(nums[i]);
                backtracking(nums);
                visit[i] = false;
                path.removeLast();
            }
        }
    }
}
