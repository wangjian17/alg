package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class algTree111 {

    public int minDepth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return 0;
        queue.offer(root);

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            ++result;
            for (int i = 0; i < size; i++) {
                // 取出节点
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return result;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return result;
    }
}
