package leetcode.normal;

import leetcode.datastruct.TreeNode;
import leetcode.datastruct.TreeNodeUtils;

import java.util.*;

public class algTree102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 使用队列
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root != null)
            queue.add(root);

        // 结果

        while (!queue.isEmpty()){

            int size = queue.size();
            ArrayList<Integer> partResult = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                // 取出节点
                TreeNode node = queue.poll();

                // 添加节点
                partResult.add(node.val);

                // 放入新节点
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

            }
            result.add(partResult);
        }

        return result;

    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>(List.of(1, TreeNodeUtils.NULL, 2, 3, 4));


        TreeNode root = TreeNodeUtils.buildFromLists(list);

        TreeNodeUtils.print(root);
    }




}
