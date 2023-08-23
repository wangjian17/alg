package leetcode.normal.dp;

import java.util.Arrays;

public class algDP787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // k个中转 对应k + 1条路线
        k++;


        // 1、dp[i][j] 表示 进过i条路线 从 src到 j的最小权重为dp[i][j]
        int[][] dp = new int[k + 1][n];

        // 确保不越界
        int MAX_VALUE = 10000 * n + 1;
        // 2、初始化
        for (int[] dp_i : dp) {
            Arrays.fill(dp_i, MAX_VALUE);
        }

        dp[0][src] = 0;

        // 先遍历航班次数
        for (int i = 1; i <= k; i++) {
            // 遍历每一条航线
            for (int[] flight : flights) {

                int from = flight[0];
                int to = flight[1];
                int weight = flight[2];

                // 状态转移
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + weight);
            }
        }

        // 从选择一条最小的
        int result = MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            result = Math.min(result, dp[i][dst]);
        }


        return result == MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int n = 3;

        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};

        System.out.println(new algDP787().findCheapestPrice(n, flights, 0, 2, 0));
    }
}
