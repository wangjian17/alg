package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class algTree652 {

    public static final String SEP = ",";
    public static final String NULL = "#";

    // 存放结果
    LinkedList<TreeNode> list;

    // 使用哈希表来记录树的结构和出现的次数
    // 将树序列化来展示树的结构
    HashMap<String, Integer> objectMapping;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        // 使用后序遍历 遍历出所有的结构

        list = new LinkedList<>();
        objectMapping = new HashMap<>();
        traversalForPost(root);
        return list;
    }

    private String traversalForPost(TreeNode root) {
        // 终止条件
        if (root == null){
            return "NULL";
        }

        String leftJson = traversalForPost(root.left);
        String rightJson = traversalForPost(root.right);

        String struct = leftJson + SEP + rightJson + SEP + root.val;

        Integer numbers = objectMapping.getOrDefault(struct, 0);
        if (numbers == 1) {
            list.add(root);
        }
        objectMapping.put(struct, numbers + 1);

        return struct;
    }
}
