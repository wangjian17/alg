package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class algTree94 {

    public List<Integer> inorderTraversalUnify(TreeNode root) {

        // 必须要用到栈
        Stack<TreeNode> stack = new Stack<>();

        // 存放结果
        List<Integer> result = new ArrayList<>();

        if (root != null)
            stack.push(root);

        while (!stack.empty()){
            // 取出这个节点
            TreeNode node = stack.pop();

            // 如果没有被访问
            if (node != null){

                if (node.right != null) stack.push(node.right);
                stack.push(node);
                // 做标记 已经遍历过了
                stack.push(null);
                if (node.left != null) stack.push(node.left);

            }else{

                TreeNode nodeToVisit = stack.pop();
                result.add(nodeToVisit.val);
            }

        }

        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        // 必须要用到栈
        Stack<TreeNode> stack = new Stack<>();

        // 存放结果
        List<Integer> result = new ArrayList<>();

        TreeNode p = root;
        while (p != null || !stack.empty()){
            if (p != null){
                // 压栈并指向左边
                stack.push(p);
                p = p.left;
            }else {
                // 取出节点
                TreeNode node = stack.pop();
                // 访问
                result.add(node.val);
                // p 改变指向其右节点
                p = node.right;
            }

        }

        return result;
    }
}
