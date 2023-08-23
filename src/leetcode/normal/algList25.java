package leetcode.normal;

import leetcode.datastruct.ListNode;

public class algList25 {

    public ListNode reverseKGroup(ListNode head, int k) {


        // 开头a 终止b [a, b)
        ListNode a = head;
        ListNode b = head;

        for (int i = 0; i < k; i++) {
            if (b != null) {
                b = b.next;
            } else{
                return head;
            }
        }

        // 反转后a是最后一个元素了
        ListNode p = reverse(a, b);
        a.next = reverseKGroup(b, k);

        return p;

    }


    // 1 > 2 >3  -> null < 1 < 2 < 3
    private ListNode reverse(ListNode a, ListNode b) {

        ListNode p = a, pre = null, next;
        while (p != b) {

            // 先保存下一个
            next = p.next;
            // 指向后边的指向了前面
            p.next = pre;
            // pre 变化
            pre = p;
            p = next;
        }
        return pre;
    }
}
