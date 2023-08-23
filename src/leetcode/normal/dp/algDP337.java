package leetcode.normal.dp;

import leetcode.datastruct.TreeNode;

public class algDP337 {

    public int rob(TreeNode root) {

        int[] result = robbing(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robbing(TreeNode root) {

        if (root == null) return new int[]{0, 0};

        int[] left = robbing(root.left);
        int[] right = robbing(root.right);

        // 0 偷 1不偷
        int robRoot = left[1] +  right[1]+ root.val;

        int robNoRoot = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);

        return new int[]{robRoot, robNoRoot};
    }


}
