package leetcode.normal.dp;

import java.util.Arrays;

public class algDP322 {

    public int coinChange(int[] coins, int amount) {

        // 1、dp[i]的含义 表示 金额i需要最少dp[i]个硬币
        int[] dp = new int[amount + 1];

        // 2、初始化 有可能无法通过硬币凑成金额 所以这里先初始化为一个非法值
        // Integer.MAX_VALUE 表示无法凑成
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 一定要存在一个初始条件 不然无法进行状态转移
        dp[0] = 0;

        // 3、先遍历coins 或者 amount都可以
        for (int coin : coins) {
            // 这里不考虑比 coin 金额低的金额了
            for (int i = coin; i <= amount; i++) {
                // 4.1、状态转移条件：dp[i - coins]可以凑得出来
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    // 4.2、状态转移方程：dp[i] = dp[i - coins] + 1;
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        // 最后要做判断 能不能凑成硬币
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
