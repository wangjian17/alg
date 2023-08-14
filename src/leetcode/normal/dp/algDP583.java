package leetcode.normal.dp;

public class algDP583 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        // 1、定义dp[i][j] 表示word1中以i- 1结尾的字符串 和 word2中以j - 1结尾的字符串的最小距离
        int[][] dp = new int[m + 1][n + 1];

        // 2、初始化 一个为空 就是全删除
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        // 3、便利顺序
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
