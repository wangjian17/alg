package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.Stack;

public class algBST538 {

    // 算法思想：按照右中做顺序遍历，并累加
    public TreeNode convertBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return root;

        // 记录需要累加的数值
        int count = 0;
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if (p != null) {
                stack.push(p);
                p = p.right;
            }else{
                p = stack.pop();
                // 更新值
                p.val += count;
                count = p.val;
                // 左边啦
                p = p.left;
            }
        }
        return root;
    }


}
