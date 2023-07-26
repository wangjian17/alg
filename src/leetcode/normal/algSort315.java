package leetcode.normal;

import java.util.*;

public class algSort315 {

    // 存放结果
    int[] result;
    // 临时合并计算使用
    Pair[] temp;

    // 存放数字和原始索引的映射关系
    // 不能使用哈希表 如果有重复的元素 会映射错误
    // 这里相当于存储了一个节点对应一个索引 所以如果有重复元素 也不会报错
    Pair[] arr;

    private class Pair {
        int value, index;
        Pair(int value, int index) {
            // 记录数组的元素值
            this.value = value;
            // 记录元素在数组中的原始索引
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {

        result = new int[nums.length];
        temp = new Pair[nums.length];
        arr = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        sort(nums, 0, nums.length - 1);

        // 结果转变为ArrayList
        ArrayList<Integer> finalResult = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            finalResult.add(result[i]);
        }
        return finalResult;
    }

    private void sort(int[] nums, int left, int right) {

        // 终止条件
        if (left == right) return;

        int mid = (right - left) / 2 + left;

        // 左右遍历
        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        // 拷贝数组
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        // 提取位置
        int p1 = left, p2 = mid +1;

        for (int p = left; p < right + 1; p++) {

            if (p1 == mid + 1 || (p2 <= right && temp[p2].value < temp[p1].value)){
                arr[p] = temp[p2++];
            }else{
                arr[p] = temp[p1++];
                result[arr[p].index] += p2 - mid - 1;
            }


        }
    }

    public static void main(String[] args) {
        int[] b = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        List<Integer> list = new algSort315().countSmaller(b);
        System.out.println(list);
//        System.out.println(Arrays.toString(b));
    }
}
