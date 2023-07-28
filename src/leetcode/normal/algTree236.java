package leetcode.normal;

import leetcode.datastruct.TreeNode;

public class algTree236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 每个节点的值互不相同
        return find(root, p.val, q.val);

    }

    private TreeNode find(TreeNode root, int val, int val1) {
        // 终止条件
        if (root == null) return null;

        // 先序位置 如果找到某一个节点 那么必然另一个节点在他的下面
        // 这是一个入口
        if (root.val == val1 || root.val == val) {
            return root;
        }

        // 后序位置 左右子树中分别存在p，q节点
        TreeNode left = find(root.left, val, val1);
        TreeNode right = find(root.right, val, val1);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
