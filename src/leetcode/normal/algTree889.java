package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class algTree889 {

    Map<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        // 后续数组的位置关系 保存
        map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        // 切分方式有多种 咋就按照平分的切法 时间复杂度比较高
        return findNode(preorder, 0, preorder.length,
                postorder, 0, postorder.length);

    }


    public TreeNode findNode(int[] preorder, int preBegin, int preEnd,
                             int[] postorder, int postBegin, int postEnd) {

        // 终止条件
        if (postBegin >= postEnd) {
            return null;
        }

        // 构建根节点
        TreeNode root = new TreeNode(preorder[preBegin]);

        // 这里将前序遍历第二个节点作为左子树的根节点
        // 先判断是否存在
        if (preBegin + 1 == preEnd){
            return root;
        }

        // 分割点是要的 并且在postorder的左边
        Integer split = map.get(preorder[preBegin + 1]);

        root.left = findNode(preorder, preBegin + 1, preBegin + 2 + split - postBegin, postorder, postBegin, split + 1);
        root.right = findNode(preorder, preBegin + 2 + split - postBegin, preEnd, postorder, split + 1, postEnd - 1);

        return root;
    }
}
