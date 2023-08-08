package leetcode.normal;

import leetcode.datastruct.ListNode;

import java.util.PriorityQueue;

public class algPQ23 {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> priorityQueue
                = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);


        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        // 添加所有头结点
        for (int i = 0; i < lists.length; i++) {

            if (lists[i] != null)
                priorityQueue.offer(lists[i]);
        }

        while (!priorityQueue.isEmpty()) {
            // 每次取出最小的元素
            ListNode node = priorityQueue.poll();

            if (node.next != null)
                priorityQueue.offer(node.next);

            tail.next = node;
            tail = tail.next;
        }

        return dummyHead.next;
    }
}
