package leetcode.normal.dp;

public class algDP115 {

    public int numDistinct(String s, String t) {

        // s是否包含t可以理解为 s中是否可以通过删除某些字符 成为t

        int m = s.length();
        int n = t.length();

        // 1、dp[i][j] 表示s以i - 1为结尾的字符串包含t以j - 1为结尾的字符串的个数
        int[][] dp = new int[m + 1][n + 1];

        // 2、初始化 当t为空的时候 s可以将所有字符全部删除得到t 因此是一个
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // 3、遍历
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // s以i-1为结尾的字符串至少和以i - 2结尾的字符串包含相同多的t以j - 1为结尾的字符串
                dp[i][j] = dp[i - 1][j];

                // 如果s[i-1] == t[j - 1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 状态转移
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

}
