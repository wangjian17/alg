package leetcode.normal;

import leetcode.datastruct.TreeNode;

public class algBST700 {

    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode p = root;
        while (p != null) {
            if (p.val == val) {
                return p;
            }else if (p.val < val){
                p = p.right;
            }else{
                p = p.left;
            }
        }

        return null;
    }

}
