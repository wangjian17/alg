package leetcode.normal.dp;

public class algDP309 {

    public int maxProfit(int[] prices) {

        int length = prices.length;

        //      0购买阶段
        //      1刚卖阶段
        //      2冷冻期
        //      3卖出阶段

        int[][] dp = new int[length][4];

        dp[0][0] = -prices[0];

        for (int i = 1; i < length; i++) {

            // 维持现状 or 今天买这个(昨天不是刚卖就可以买)
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][2]) - prices[i]);
            // 卖了
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 前一天刚卖
            dp[i][2] = dp[i - 1][1];
            // 维持现状 or 前一天冷冻期
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);
        }


        return Math.max(dp[length - 1][3], Math.max(dp[length - 1][2], dp[length - 1][1]));
    }
}
