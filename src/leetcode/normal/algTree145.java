package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class algTree145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        // 同样，需要用到栈
        Stack<TreeNode> stack = new Stack<>();
        // 存放结果
        List<Integer> result = new ArrayList<>();

        // 将根节点压入栈
        if (root != null) {
            stack.push(root);
        }

        while (!stack.empty()) {
            // 先取出节点
            TreeNode node = stack.pop();

            if (node != null){
                // 遍历
                stack.push(node);
                // 标记
                stack.push(null);

                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);

            }else{
                // 取出节点
                TreeNode nodeToVisit = stack.pop();
                // 访问
                result.add(nodeToVisit.val);
            }
        }
        return result;
    }
}
