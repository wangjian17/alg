package leetcode.normal;

import leetcode.datastruct.TreeNode;

public class algBST235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        TreeNode cur = root;
        while (cur != null){
            int val = cur.val;
            if (min <= val && max >= val) {
                return cur;
            }else if (max < val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        return null;
    }

}
