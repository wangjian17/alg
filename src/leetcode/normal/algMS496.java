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

        // 实现单调栈
        Stack<Integer> stack = new Stack<>();
        // 从右往左遍历

        for (int i = 0; i < ; i++) {
            
        }
    }
    
}
