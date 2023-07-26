package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.Stack;

public class algBST98 {

    // 算法思想 中序遍历 与前一个节点比较值得大小
    // 常见错误：只比较某个节点的左右节点 因为BST的定义是和左右子树有关而不是左右节点
    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        TreeNode p = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                if (pre != null && p.val <= pre.val) return false;
                pre = p;
                p = p.right;
            }
        }

        return true;
    }
}
