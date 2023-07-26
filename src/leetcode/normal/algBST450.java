package leetcode.normal;

import leetcode.datastruct.TreeNode;

public class algBST450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        // 非递归条件归于复杂 这里用递归来写
        // 终止条件
        if (root == null) return null;

        if (key == root.val){

            // 情况1 叶子节点,直接删除
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                // 单孩子节点
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else{
                // 孩子节点都存在
                // 找到左子树的最大节点
                TreeNode maxNode = findMax(root.left);

                // 删除这个最大节点
                root.left = deleteNode(root.left, maxNode.val);

                maxNode.left = root.left;
                maxNode.right = root.right;
                return maxNode;
            }

        }else if (key < root.val){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    private TreeNode findMax(TreeNode root) {
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
}
