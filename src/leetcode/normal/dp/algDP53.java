package leetcode.normal.dp;

public class algDP53 {

    public int maxSubArray(int[] nums) {

        int length = nums.length;

        // 1、dp[i]表示以i结尾的子数组最大值
        int[] dp = new int[length];

        dp[0] = nums[0];

        int result = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            result = Math.max(dp[i], result);
        }

        return result;
    }
}
