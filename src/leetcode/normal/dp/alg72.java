package leetcode.normal.dp;

public class alg72 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        // 1、定义dp[i][j] 表示 word1以i - 1结尾的字符串和word2以j - 1结尾的字符串的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];

        // 2、初始化 如果有一个为空 那最小的编辑距离就是全部删除
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        // 3、遍历顺序
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 两种条件
                // 相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 只要动前面的就行
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    // 情况1：删除word1中最后面一个元素 其实和在word2中添加一个元素是一样的 因为相同的元素会消除
                    dp[i][j] = dp[i - 1][j] + 1;
                    // 情况2：删除word2中最后一个元素
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    // 情况3：修改word1中的元素或者修改word2中的元素 相等后就等于消除了这两个元素
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
