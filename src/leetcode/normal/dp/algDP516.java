package leetcode.normal.dp;

public class algDP516 {

    public int longestPalindromeSubseq(String s) {

        int length = s.length();

        // dp[i,j] 表示 s[i,j]回文子序列的个数
        int[][] dp = new int[length][length];

        // 初始化 中间的都是1
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int i = length - 1; i >= 0; --i) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 就算 i + 1 > j - 1问题也不大
                    // 因为那里一定是dp[i + 1][j - 1] = 0
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }
}
