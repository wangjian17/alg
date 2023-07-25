package leetcode.datastruct;

import leetcode.normal.algTree102;

import java.util.*;

public class TreeNodeUtils {

    public static final Integer NULL = Integer.MAX_VALUE;


    // 构建二叉树
    public static TreeNode buildFromLists(LinkedList<Integer> lists) {

        if (lists == null || lists.size() == 0) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();

        // 将根节点加入队列
        Integer nodeInfo = lists.removeFirst();
        TreeNode root = new TreeNode(nodeInfo);
        queue.add(root);


        // 层次遍历
        while (!queue.isEmpty() && !lists.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // 取节点
                TreeNode node = queue.poll();

                if (lists.isEmpty()){
                    break;
                }

                Integer value = lists.removeFirst();
                if (!Objects.equals(value, NULL)) {
                    node.left = new TreeNode(value);
                    queue.add(node.left);
                }else{
                    node.left = null;
                }

                if (lists.isEmpty()){
                    break;
                }

                value = lists.removeFirst();
                if (!Objects.equals(value, NULL)) {
                    node.right = new TreeNode(value);
                    queue.add(node.right);
                }else{
                    node.right = null;
                }
            }

        }

        return root;
    }



    public static void print(TreeNode root) {
        List<List<Integer>> lists = new algTree102().levelOrder(root);

        for (List<Integer> yyy: lists) {
            for (int y: yyy) {
                System.out.print(y);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
