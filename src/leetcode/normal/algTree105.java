package leetcode.normal;


import leetcode.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class algTree105 {

    // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    // 结果[3,9,20,null,null,15,7]

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 为了提供查询效率， 用 Map存储
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 构建二叉树
        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }


    // 这里是一个开区间 [preBegin, preEnd)
    public TreeNode findNode(int[] preorder, int preBegin, int preEnd,
                             int[] inorder, int inBegin, int inEnd) {

        if (preBegin >= preEnd){
            return null;
        }

        // 构建根节点
        TreeNode root = new TreeNode(preorder[preBegin]);

        // 找到分割节点
        Integer split = map.get(preorder[preBegin]);

        // 遍历左右
        root.left = findNode(preorder, preBegin + 1, preBegin + split - inBegin + 1, inorder, inBegin, split);
        root.right = findNode(preorder, preBegin + split - inBegin + 1, preEnd, inorder, split + 1, inEnd);

        return root;
    }

}
