package leetcode.normal;

import leetcode.datastruct.Pair;

import java.util.*;

public class algSort315 {

    // 存放结果
    int[] result;
    // 临时合并计算使用
    int[] temp;

    // 存放数字和原始索引的映射关系
    HashMap<Integer, Integer> mappings;


    public List<Integer> countSmaller(int[] nums) {

        result = new int[nums.length];

        temp = new int[nums.length];

        mappings = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mappings.put(nums[i], i);
        }

        sort(nums, 0, nums.length - 1);

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
            temp[i] = nums[i];
        }

        // 提取位置
        int p1 = left, p2 = mid +1;

        for (int p = left; p < right + 1; p++) {

            if (p1 == mid + 1){
                nums[p] = temp[p2++];
            }else if (p2 == right +1){
                nums[p] = temp[p1++];
                result[mappings.get(nums[p1])] += p2 - mid - 1;
            }else if (temp[p2] < temp[p1]){
                nums[p] = temp[p2++];
            }else {
                nums[p] = temp[p1++];
                result[mappings.get(nums[p1])] += p2 - mid - 1;
            }


        }
    }

    public static void main(String[] args) {
        int[] b = {5,2,6,1};
        List<Integer> list = new algSort315().countSmaller(b);
        System.out.println(list);
        System.out.println(Arrays.toString(b));
    }
}
