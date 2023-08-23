package leetcode.normal.dp;

public class algDP213 {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int result1 = rob(nums, 0, n - 2);
        int result2 = rob(nums, 1, n - 1);
        return Math.max(result1, result2);
    }

    private int rob(int[] nums, int begin, int end) {

        int n = nums.length;
        int[] dp = new int[n];

        dp[begin] = nums[begin];
        dp[begin + 1] = Math.max(nums[begin], nums[begin + 1]);

        for (int i = begin + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }

}
