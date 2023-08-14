package leetcode.normal.dp;

import java.util.Arrays;

public class algPatientSort300 {

    public int lengthOfLISDP(int[] nums) {

        int length = nums.length;

        // 1、确定dp含义 dp[i] 表示以i为结尾的递增子序列
        int[] dp = new int[length];

        // 2、初始化 一开始都为1 包含自己一个元素
        Arrays.fill(dp, 1);

        // 3、遍历顺序从小到大
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                // 状态转移条件
                if (nums[i] > nums[j])
                    // 状态转移方程
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // dp[length -1] 并不是最终的输出结果 它的含义是 以length - 1为结尾的递增子序列
        // 所以需要遍历每个结尾的递增子序列 来得到最大的
        int result = 1;
        for (int i = 1; i < length; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public int lengthOfLIS(int[] nums) {

        int length = nums.length;

        // 先建立堆
        int[] top = new int[length];
        // 当前堆的长度
        int piles = 0;

        for (int i = 0; i < length; i++) {

            // 取出当前的数值
            int num = nums[i];

            // 在堆中找到合适的存放位置
            // 使用二分查找 因为堆中顺序 从小到大
            int left = 0, right = piles;

            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (num <= top[mid]) {
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }

            // 如果大于所有堆中元素
            if (left == piles) ++piles;
            // 在left的位置添加
            top[left] = num;
        }

        return piles;
    }
}
