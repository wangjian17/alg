package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class algTree106 {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // 构建哈希表存放 inorder中 的位置关系 查找时时间复杂度变为1
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd,
                             int[] postorder, int postBegin, int postEnd) {

        // 结束条件
        if(inEnd <= inBegin) return null;

        // 构造根节点
        TreeNode root = new TreeNode(postorder[postEnd - 1]);

        // 找到切割位置
        Integer split = map.get(postorder[postEnd - 1]);

        // 分割数组
        root.left = findNode(inorder, inBegin, split, postorder, postBegin, postBegin + split - inBegin);
        root.right = findNode(inorder, split + 1, inEnd, postorder, postBegin + split - inBegin, postEnd - 1);

        return root;
    }

}
