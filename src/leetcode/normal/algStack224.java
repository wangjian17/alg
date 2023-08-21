package leetcode.normal;

import java.util.Stack;

public class algStack224 {

    // 因为只有 + - 数字 和 空格 所以不需要考虑计算的优先级
    public int calculate(String s) {

        // 存放当前 数字之前的符号
        Stack<Integer> stack = new Stack<>();
        // 表示当前的符号
        int sign = 1;
        stack.push(1);

        int result = 0;

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 先取出完整的数字
            while (i < s.length() && Character.isDigit(ch)) {

                num = num * 10 + ch - '0';
                if (++i < s.length()){
                    ch = s.charAt(i);
                }
            }

            num *= sign;
            result += num;
            num = 0;

            if (i == s.length()) {
                break;
            }

            if (ch == '+') {
                sign = stack.peek();
            }else if (ch == '-'){
                sign = -stack.peek();
            } else if (ch == '(') {
                stack.push(sign);
            } else if (ch == ')') {
                stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new algStack224().calculate("1 + 1"));
    }
}
