package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class algBST95 {

    public List<TreeNode> generateTrees(int n) {

        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int low, int high) {

        LinkedList<TreeNode> result = new LinkedList<>();

        // 终止条件 添加空节点
        if (low > high){
            result.add(null);
            return result;
        }

        for (int i = low; i <= high; i++) {

            // 得到左子树结合
            List<TreeNode> leftTrees = buildTrees(low, i - 1);
            // 得到右子树集合
            List<TreeNode> rightTrees = buildTrees(i + 1, high);
            // 遍历所有可能的子树集合

            for (TreeNode left:leftTrees) {
                for (TreeNode right: rightTrees) {
                    // 构造根节点
                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }


}
