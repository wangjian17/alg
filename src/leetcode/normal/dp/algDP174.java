package leetcode.normal.dp;

public class algDP174 {

    public int calculateMinimumHP(int[][] dungeon) {

        int n = dungeon.length;
        int m = dungeon[0].length;

        // dp[i][j] 表示 从i,j 到右下角最少需要多少血量
        int[][] dp = new int[n][m];

        if (dungeon[n - 1][m - 1] >= 0) {
            dp[n - 1][m - 1] = 1;
        }else{
            dp[n - 1][m - 1] = 1 - dungeon[n - 1][m - 1];
        }

        // 最右边
        for (int i = n - 2; i >= 0; --i) {
            dp[i][m - 1] = dp[i + 1][m - 1] - dungeon[i][m - 1];
            if (dp[i][m - 1] < 0) {
                dp[i][m - 1] = 1;
            }
        }

        // 最下面
        for (int i = m - 2; i >= 0; --i) {
            dp[n - 1][i] = dp[n - 1][i + 1] - dungeon[n - 1][i];
            if (dp[n - 1][i] < 0) {
                dp[n - 1][i] = 1;
            }
        }

        // 遍历顺序从下往上 从有往左
        for (int i = n - 2; i >= 0; --i) {
            for (int j = m - 2; j >= 0; --j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] < 0) {
                    dp[i][j] = 1;
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        new algDP174().calculateMinimumHP(nums);
    }
}
