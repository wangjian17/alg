package leetcode.normal.dp;

public class algDP64 {
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        // 1、dp[i][j] 表示从0 0 到i j 的权值最小的路径的权值
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];
        // 2、初始化第一行
        for (int i = 1; i < m; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        // 初始化第一列
        for (int i = 1; i < n; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }


        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        new algDP64().minPathSum(grid);
    }
}
