package leetcode.normal.dp;

public class algDP1143 {


    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        // 1、dp[i][j]表示 text1以i - 1结尾, text2以j - 1结尾的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];

        // 2、初始化 某个为空就是0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        // 3、遍历
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 相等时转移
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    //不相等也是需要向上或者向左转移
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

}
