package leetcode.normal.dp;

public class algStock121 {

    public int maxProfitGreedy(int[] prices) {

        int result = 0;
        int accumulate = 0;

        for (int i = 1; i < prices.length; i++) {
            accumulate += (prices[i] - prices[i - 1]);
            if (accumulate < 0) {
                accumulate = 0;
            }
            result = Math.max(result, accumulate);
        }

        return result;
    }

    public int maxProfit(int[] prices) {

        // 两个状态 0 表示持有股票 1表示不持有股票
        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            // 亏得钱尽可能少
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            // 赚的钱尽可能多
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }
}
