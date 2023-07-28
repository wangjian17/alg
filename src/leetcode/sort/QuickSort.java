package leetcode.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static int[] sortArray(int[] nums) {

        // 洗牌，增加快速排序的鲁棒性
        shuffle(nums);

        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void shuffle(int[] nums) {

        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 随机交换位置
            // 生成 [i, n - 1] 的随机数
            int r = i + random.nextInt(n - i);
            swap(nums, r, i);
        }
    }

    private static void sort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) return;

        // 拍好一个数的顺序
        int mid = partition(nums, left, right);

        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {

        int i = left + 1, j = right;

        int anchor = nums[left];

        // 这里定义两个区间 [left. i) 以及(j, right]
        // 并且 nums[left. i) <= anchor, nums(j,right] > anchor
        while (i <= j){

            // 从左边开始
            while (nums[i] <= anchor && i < right){
                ++i;
            }

            while (nums[j] > anchor && j > left){
                --j;
            }

            if (i >= j) break;

            swap(nums, i, j);
        }
        // 最终j这个位置 nums[j] < anchor
        swap(nums, j, left);

        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmep = nums[i];
        nums[i] = nums[j];
        nums[j] = tmep;
    }

    public static void main(String[] args) {
        int[] nums = {1, 312, 3, 532, 232, 12};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
}
