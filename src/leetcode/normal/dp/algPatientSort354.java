package leetcode.normal.dp;

import java.util.Arrays;

public class algPatientSort354 {

    public int maxEnvelopes(int[][] envelopes) {

        // 这道题实际上是二维的耐心排序 如果 a1[1] < a2[1] && a1[0] < a2[0]
        // =>> a1 可以放在 a2 的上面

        // 所以这里的排序非常重要
        // 首先根据宽排序 从小到大 然后根据高排序 从大到小
        // 这样子的话宽度一致 两个高度不同也不能堆在一起 只能算一个
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int length = envelopes.length;
        int[] height = new int[length];

        // 赋值
        for (int i = 0; i < length; i++) {
            height[i] = envelopes[i][1];
        }

        // 耐性排序 和 354题差不多
        return patientSort(height);
    }

    private int patientSort(int[] height) {

        int length = height.length;
        // 创建堆
        int piles = 0;
        int[] top = new int[length];

        for (int i = 0; i < length; i++) {
            int num = height[i];

            // 开始找到堆中合适的位置
            int left = 0, right = piles;
            // 二分查找
            while (left < right) {

                int mid = (right - left) / 2 + left;

                if (num <= top[mid]) {
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }

            // 添加值
            if (left == piles) ++piles;
            top[left] = num;
        }
        return piles;
    }
}
