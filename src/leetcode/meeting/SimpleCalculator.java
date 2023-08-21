package leetcode.meeting;

import java.util.Stack;

public class SimpleCalculator {

    // 字符包含 数字 + - * / 以及空格
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        char preOperation = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            // 取出
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // 如果是数字 就拼接
                num = num * 10 + ch - '0';
            }

            // 遇到符号后就计算新的值 或者 到最后了
            if (i == s.length() - 1 || (!Character.isDigit(ch)) && ch != ' ') {
                switch (preOperation) {
                    case '+' -> {
                        stack.push(num);
                    }
                    case '-' -> {
                        stack.push(-num);
                    }
                    case '*' ->{
                        int top = stack.pop() * num;
                        stack.push(top);
                    }
                    case '/' ->{
                        int top = stack.pop() / num;
                        stack.push(top);
                    }
                }

                preOperation = ch;
                num = 0;
            }
        }

        int result = 0;
        for (Integer number : stack) {
            result += number;
        }

        return result;
    }
}
