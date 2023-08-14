package leetcode.normal.dp;

import java.util.Arrays;

public class alg931DP {

    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        // 1、dp[i][j] 表示 以ij结尾的下降路径最短长度
        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 2、初始化 第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        // 定义三个方向
        int[] directions = {-1, 0, 1};

        // 3、从上到下遍历
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 三个地方可以遍历
                for (int direction : directions) {
                    int newJ = j + direction;
                    // 4.1状态转移条件
                    if (judge(newJ, n)) {
                        // 4.2状态转移方程
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][newJ] + matrix[i][j]);
                    }
                }
            }
        }


        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[m - 1][i]);
        }

        return result;
    }

    // 判断是否没有超过边界
    private boolean judge(int i, int n) {
        return i >= 0 && i < n;
    }

}
