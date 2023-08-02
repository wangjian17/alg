package leetcode.normal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class algBacktracking40 {

    List<List<Integer>> result;
    LinkedList<Integer> path;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 因为可以重复 所以要先排序
        Arrays.sort(candidates);

        result = new LinkedList<>();
        path = new LinkedList<>();

        backtracking(candidates, target, 0);

        return result;
    }

    private void backtracking(int[] candidates, int target, int start) {

        if (target == 0){
            result.add(new LinkedList<>(path));
            return;
        }

        // 剪枝
        if (target < 0){
            return;
        }

        // 遍历啦
        for (int i = start; i < candidates.length; i++) {
            // 去重
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i +1);
            path.removeLast();
        }
    }

}
