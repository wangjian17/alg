package leetcode.normal;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class algPQ347 {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }


        // 这是大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue
                = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        priorityQueue.addAll(hashMap.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }

        return result;
    }
}
