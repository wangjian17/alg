package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangjian
 * @create 2023-07-30 16:55
 * @function
 */
public class algTree107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        // 使用LinkedList保存结果 头插
        LinkedList<List<Integer>> result = new LinkedList<>();

        // 使用队列
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                // 取出节点
                TreeNode node = queue.poll();
                temp.add(node.val);

                // 添加节点
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.addFirst(temp);
        }

        return result;
    }
}
