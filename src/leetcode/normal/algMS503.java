package leetcode.normal;

import java.util.Stack;

public class algMS503 {

    public int[] nextGreaterElements(int[] nums) {

        int size = nums.length;
        int[] result = new int[size];

        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < 2; j++) {
            for (int i = nums.length - 1; i >= 0; --i) {

                int num = nums[i];

                while (!stack.empty() && stack.peek() <= num) {
                    stack.pop();
                }

                if (stack.isEmpty()){
                    result[i] = -1;
                }else {
                    result[i] = stack.peek();
                }
                stack.push(num);
            }
        }

        return result;
    }
}
