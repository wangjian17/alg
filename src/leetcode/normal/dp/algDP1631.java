package leetcode.normal.dp;

import java.util.Arrays;

public class algDP1631 {

    // DP 不行 因为状态转移不只是看上面和左边
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        // 初始化 第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], Math.abs(heights[0][i] - heights[0][i - 1]));
        }

        // 初始化 第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.abs(heights[i][0] - heights[i - 1][0]));
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(
                        Math.max(Math.abs(heights[i][j] - heights[i - 1][j]), dp[i - 1][j]),
                        Math.max(Math.abs(heights[i][j] - heights[i][j - 1]), dp[i][j - 1]));
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        };
        new algDP1631().minimumEffortPath(heights);
    }

}
