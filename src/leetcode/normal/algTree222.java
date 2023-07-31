package leetcode.normal;

import leetcode.datastruct.TreeNode;

public class algTree222 {

    // 整体时间复杂度是O(lgn * lgn)
    // 递归的深度是lgn 也就是树的高度， 原因在于左右子树一定有一颗 满二叉树
    // 每次执行的时间复杂度为lgn
    public int countNodes(TreeNode root) {

        if (root == null) return 0;

        TreeNode left = root.left, right = root.right;

        int left_level = 0, right_level = 0;
        while (left != null) {
            ++left_level;
            left = left.left;
        }

        while (right != null) {
            ++right_level;
            right = right.right;
        }

        // 表示满二叉树
        if (left_level == right_level) {
            return (1 << (left_level + 1)) - 1;
        }

        // 表示是普通二叉树
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


}
