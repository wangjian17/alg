package leetcode.normal.dp;

public class algStock188 {

    public int maxProfit(int k, int[] prices) {

        int length = prices.length;

        // dp[i][j][k] 第i天，第k此交易 持有 卖出
        // 为了同意需要加入一个初始状态
        int[][][] dp = new int[length][k + 1][2];

        // 初始化
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
            }
        }

        return dp[length - 1][k][1];

    }

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {2, 4, 1};
        new algStock188().maxProfit(k, nums);
    }
}
