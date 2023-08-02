package leetcode.normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class algBacktracking39 {


    List<List<Integer>> result;
    LinkedList<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new LinkedList<>();
        path = new LinkedList<>();

        Arrays.sort(candidates);

        backtracking(candidates, target, 0);

        return result;

    }

    private void backtracking(int[] candidates, int target, int start) {

        // 终止条件
        if (target == 0){
            result.add(new LinkedList<>(path));
            return;
        }

        // 剪枝
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}
