package leetcode.normal;

import java.util.Stack;

public class algMS739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int size = temperatures.length;
        int[] result = new int[size];

        // 单调栈 栈里面存放位置 不存放温度
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; --i) {
            int temperature = temperatures[i];
            // 存储索引 位置
            // 这里一定要把 = 也给删除 因为要求是大的
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperature){
                stack.pop();
            }

            if (stack.isEmpty()){
                result[i] = 0;
            }else{
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }

}
