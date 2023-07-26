package leetcode.normal;

import leetcode.datastruct.TreeNode;

public class algBST701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        TreeNode p = root;
        TreeNode pre = null;

        while (p != null){
            pre = p;
            if (p.val < val){
                p = p.right;
            }else{
                p = p.left;
            }
        }

        if (pre.val < val){
            pre.right = new TreeNode(val);
        }else{
            pre.left = new TreeNode(val);
        }

        return root;
    }
}
