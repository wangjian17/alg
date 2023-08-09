package leetcode.normal;

import java.util.HashMap;
import java.util.Stack;

public class algMS496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // nums2上的元素 映射到 nums1上的位置
        HashMap<Integer, Integer> mappingsFromNums2ToNums1 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            mappingsFromNums2ToNums1.put(nums1[i], i);
        }

        int[] result = new int[nums1.length];
        // 实现单调栈
        Stack<Integer> stack = new Stack<>();
        // 从右往左遍历

        for (int i = nums2.length - 1; i >= 0; --i) {
            // 把后面小的都挡住了 因此删除比当前元素小的
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // 如果这个数在num1中存在
            if (mappingsFromNums2ToNums1.containsKey(num)) {
                Integer index = mappingsFromNums2ToNums1.get(num);
                if (stack.isEmpty()){
                    result[index] = -1;
                }else{
                    result[index] = stack.peek();
                }
            }
            stack.push(num);
        }

        return result;
    }
    
}
