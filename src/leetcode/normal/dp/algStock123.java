package leetcode.normal.dp;

public class algStock123 {

    // 最多两笔
    public int maxProfit(int[] prices) {

        // 0第一笔购买 1第一笔结束 2第二笔购买 3第二笔结束
        int n = prices.length;

        int[][] dp = new int[n][4];

        dp[0][0] = dp[0][2] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 维持现状 or 现在开买
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 维持现状 or 开卖
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);

            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        return dp[n - 1][3];

    }
}
