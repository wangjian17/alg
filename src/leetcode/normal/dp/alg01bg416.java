package leetcode.normal.dp;

public class alg01bg416 {

    public boolean canPartition(int[] nums) {

        int length = nums.length;

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;

        int[] dp = new int[sum + 1];

        for (int num : nums) {
            for (int i = sum; i >= num; --i) {
                dp[i] = Math.max(dp[i], dp[i - num] + num);
            }
        }

        if (dp[sum / 2] == sum / 2) {
            return true;
        }

        return false;
    }
}

