package leetcode.sort;

import java.util.Arrays;

public class MergeSort {

    // 用于合并操作
    public static int[] temp;

    public static int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    // 闭区间[left, right]
    public static void sort(int[] nums, int left, int right) {

        // 终止条件
        if (left == right) return;

        // 得到中间节点
        int mid = (right - left) / 2 + left;

        // 后序遍历
        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        // 合并
        merge(nums, left, right, mid);
    }

    private static void merge(int[] nums, int left, int right, int mid) {

        // 比较大小的两个位置
        int p1 = left, p2 = mid + 1;

        // 数组拷贝
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // 合并数组
        for (int p = left; p <= right; p++) {

            // 这里的边界是mid+1 是不可以越界的地方 下面的p2也是
            if (p1 == mid + 1){
                nums[p] = temp[p2++];
            }else if (p2 == right + 1){
                nums[p] = temp[p1++];
            }else if (temp[p2] < temp[p1]){
                nums[p] = temp[p2++];
            }else{
                nums[p] = temp[p1++];
            }
        }
    }

}
