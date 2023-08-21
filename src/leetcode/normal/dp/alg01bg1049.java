package leetcode.normal.dp;

public class alg01bg1049 {

    public int lastStoneWeightII(int[] stones) {

        // 本题目 可以 转换为 选择一堆石头和另一堆石头相撞 最后剩下多少
        // 尽可能两堆石头的重量接近

        int sum = 0;
        int length = stones.length;

        for (int i = 0; i < length; i++) {
            sum += stones[i];
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int i = target; i >= stone; --i) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - 2 * dp[target];
    }
}
