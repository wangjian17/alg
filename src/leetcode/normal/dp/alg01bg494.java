package leetcode.normal.dp;

public class alg01bg494 {

    public int findTargetSumWays(int[] nums, int target) {

        // 添加+号的数字的和为 left 添加-号的数字的和为 right
        // left + right = sum
        // left - right = target
        // left = (sum + target) / 2
        // 所以转换问题为 选择哪些物品 使价值为left的方案数目

        // 有可能target为负数 这是等价转换
        if (target < 0) target = -target;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 == 1) return 0;

        target = (sum + target) / 2;

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int num : nums) {
            for (int i = target; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }


}
