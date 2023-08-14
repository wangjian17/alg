package leetcode.normal.dp;

import java.util.List;

public class algDP139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        // 1、dp[i] 表示 s以i - 1是否可以用 wordDict拼出来
        int length = s.length();
        boolean[] dp = new boolean[length + 1];

        // 2、初始化 出口
        dp[0] = true;

        // 3、先遍历词典 在遍历长度
        for (int i = 0; i <= length; i++) {
            for (String word : wordDict) {
                // 4 状态转移
                if (i >= word.length() && s.substring(i - word.length(), i).equals(word) && dp[i - word.length()]) {
                    dp[i] = true;
                }
            }
        }

        return dp[length];
    }
}
