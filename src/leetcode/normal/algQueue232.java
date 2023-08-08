package leetcode.normal;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int x) {

        // 直接压栈1
        stack1.push(x);
    }

    public int pop() {

        // 如果stack2还有数据就从stack2中取 如果没有就讲stack1的元素插入到stack2
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

public class algQueue232 {
}
