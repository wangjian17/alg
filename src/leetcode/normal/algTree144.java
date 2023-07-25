package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class algTree144 {
    public List<Integer> preorderTraversalUnify(TreeNode root) {

        // 需要使用栈
        Stack<TreeNode> stack = new Stack<>();

        // 存放结果
        List<Integer> result = new ArrayList<>();

        if (root != null){
            stack.push(root);
        }

        while (!stack.empty()){
            // 取出栈顶元素
            TreeNode node = stack.pop();

            // 不为空，就是按照某种顺序添加 为空的话就弹出访问
            if (node != null){

                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);

                stack.push(node);
                // 中间节点访问过 但是没有处理 做标记
                stack.push(null);
            }else {

                TreeNode nodeToVisit = stack.pop();
                result.add(nodeToVisit.val);
            }
        }

        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        // 压入栈中
        if (root != null) stack.push(root);

        while (!stack.empty()) {
            // 取出节点
            TreeNode node = stack.pop();
            // 访问
            result.add(node.val);

            // 右边
            if (node.right != null){
                stack.push(node.right);
            }

            // 左边
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;

    }
}