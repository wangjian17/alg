package leetcode.normal;

import leetcode.datastruct.TreeNode;
import leetcode.datastruct.TreeNodeUtils;

import java.util.*;

public class algTree297 {

    public static final String SEP = ",";
    public static final String NULL = "#";
//
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//
//        // 前序遍历
//        List<TreeNode> result = new ArrayList<>();
//
//        Stack<TreeNode> stack = new Stack<>();
//
//        if (root != null) stack.push(root);
//
//        // 先序遍历
//        while (!stack.empty()) {
//            // 添加
//            TreeNode node = stack.pop();
//            result.add(node);
//
//            if (node != null) {
//                // 右
//                stack.push(node.right);
//                // 左
//                stack.push(node.left);
//            }
//
//        }
//
//        StringBuilder strings = new StringBuilder();
//
//        for (TreeNode node : result) {
//            if (node != null)
//                strings.append(node.val).append(SEP);
//            else
//                strings.append(NULL).append(SEP);
//        }
//
//        return strings.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//        // 切分数组
//        String[] strings = data.split(SEP);
//
//        if (strings.length == 0) {
//            return null;
//        }
//
//        // 使用链表存放节点
//        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
//
//        return deserialize(list);
//
//    }
//
//    private TreeNode deserialize(LinkedList<String> strings) {
//
//        if (strings.isEmpty()) {
//            return null;
//        }
//
//        String nodeInfo = strings.removeFirst();
//        System.out.println(nodeInfo);
//
//        TreeNode root;
//        if (NULL.equals(nodeInfo) || "".equals(nodeInfo)) {
//            return null;
//        } else {
//
//            root = new TreeNode(Integer.parseInt(nodeInfo));
//
//            root.left = deserialize(strings);
//            root.right = deserialize(strings);
//        }
//
//        return root;
//    }
//
//
//    public static void main(String[] args) {
//
//        LinkedList<Integer> list = new LinkedList<Integer>(List.of(1, 2, 3, TreeNodeUtils.NULL, TreeNodeUtils.NULL, 4, 5));
//        TreeNode root = TreeNodeUtils.buildFromLists(list);
//
//        TreeNodeUtils.print(root);
//
//        algTree297 solution = new algTree297();
//        String json = solution.serialize(root);
//        System.out.println(json);
//
//        TreeNode deserialize = solution.deserialize(json);
//        System.out.println(solution.serialize(deserialize));
//    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        // 层次遍历需要用到队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将结果存入String中
        StringBuilder builder = new StringBuilder();

        if (root == null) return null;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // 取出节点
                TreeNode node = queue.poll();
                // 拼接
                if (node == null)
                    builder.append(NULL).append(SEP);
                else {
                    builder.append(node.val).append(SEP);
                    // 存放左右
                    queue.add(node.left);
                    queue.add(node.right);
                }

            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) return null;
        // 拆解
        String[] strings = data.split(SEP);
        // 放入LinkedList中
        LinkedList<String> list = new LinkedList<>();

        for (String str : strings) {
            list.add(str);
        }

        // 如果本身就是空的话 第一元素也是空
        if (list.size() == 0 || "".equals(list.getFirst())) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点
        TreeNode root = new TreeNode(Integer.parseInt(list.removeFirst()));
        queue.offer(root);

        while (!queue.isEmpty() && !list.isEmpty()) {
            // 获取size
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // 获取元素
                TreeNode node = queue.poll();
                // 跳过空的
                if (node == null) {
                    continue;
                }

                if (list.isEmpty()) {
                    break;
                }
                String value = list.removeFirst();
                if (!value.equals(NULL)){
                    node.left = new TreeNode(Integer.parseInt(value));
                }else{
                    node.left = null;
                }
                queue.offer(node.left);

                if (list.isEmpty()) {
                    break;
                }

                value = list.removeFirst();
                if (!value.equals(NULL)){
                    node.right = new TreeNode(Integer.parseInt(value));
                }else{
                    node.right = null;
                }
                queue.offer(node.right);
            }
        }

        return root;


    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, TreeNodeUtils.NULL, 7));
        TreeNode root = TreeNodeUtils.buildFromLists(list);
        TreeNodeUtils.print(root);

        String serialize = new algTree297().serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = new algTree297().deserialize(serialize);
        TreeNodeUtils.print(root);


    }
}
