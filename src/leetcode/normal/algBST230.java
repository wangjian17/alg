package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.Stack;

public class algBST230 {

    // 算法思想：中序遍历 + 计数
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while (p != null || !stack.isEmpty()){

            if (p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                if (--k == 0){
                    return p.val;
                }
                p = p.right;
            }
        }

        return -1;

    }
}
