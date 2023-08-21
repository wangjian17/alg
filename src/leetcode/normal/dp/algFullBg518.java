package leetcode.normal.dp;

public class algFullBg518 {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        // 初始值
        dp[0] = 1;

        // 遍历硬币
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
