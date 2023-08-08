package leetcode.normal;

import java.util.Arrays;
import java.util.LinkedList;





public class algMonQue239 {
    private class MonotonicQueue{

        LinkedList<Integer> queue;

        public MonotonicQueue() {

            this.queue = new LinkedList<>();

        }

        public void add(Integer value){

            // 把前面所有比它小的都干掉
            while (!queue.isEmpty() && queue.peekLast() <  value){
                queue.pollLast();
            }

            queue.add(value);

        }

        public Integer peek(){
            return queue.peekFirst();
        }

        public void pop(Integer value){
            if (!queue.isEmpty() && queue.peekFirst().equals( value)){
                queue.removeFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue monotonicQueue = new MonotonicQueue();

        int size = nums.length;

        int[] result = new int[size - k + 1];

        for (int i = 0; i < k - 1; i++) {
            monotonicQueue.add(nums[i]);
        }

        for (int i = k - 1; i < size; i++) {
            monotonicQueue.add(nums[i]);
            result[i - k + 1] = monotonicQueue.peek();
            monotonicQueue.pop(nums[i - k + 1]);
        }

        return result;
    }

    public static void main(String[] args) {

        algMonQue239 algMonQue239 = new algMonQue239();
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(algMonQue239.maxSlidingWindow(nums, k)));
    }
}

