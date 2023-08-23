package leetcode.normal.dp;

public class algStock122 {

    public int maxProfitGreedy(int[] prices) {

        // 收集正向的利润
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                result += diff;
            }
        }

        return result;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][2];

        // 0 表示持有股票 1表示不持有股票
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }
}
