package leetcode.normal;


import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    // 这里使用一个队列就可以
    Queue<Integer> queue;

    // 记录队尾元素 用于快速找到
    int tail = 0;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.offer(x);
        tail = x;

    }

    public int pop() {

        int size = queue.size();

        // 将对头的元素重新插入队尾
        while (--size > 1){
            queue.offer(queue.poll());
        }

        // 队尾元素发生改变
        tail = queue.peek();

        queue.offer(queue.poll());

        return queue.poll();
    }

    public int top() {

        return tail;
    }

    public boolean empty() {

        return queue.isEmpty();
    }
}

public class algStack225 {
}
