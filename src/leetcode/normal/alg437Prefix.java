package leetcode.normal;

import leetcode.datastruct.TreeNode;

import java.util.HashMap;

public class alg437Prefix {
    int result = 0;
    long prefixSum = 0;
    HashMap<Long, Integer> prefixMap;

    public int pathSum(TreeNode root, int targetSum) {


        if (root == null) return 0;
        prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);
        traversal(root, targetSum);
        return result;
        
    }

    private void traversal(TreeNode root, int targetSum) {

        prefixSum += root.val;

        if (prefixMap.containsKey(prefixSum - targetSum)) {
            result += prefixMap.get(prefixSum - targetSum);
        }

        prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);

        if (root.left != null) {
            traversal(root.left, targetSum);
        }

        if (root.right != null){
            traversal(root.right, targetSum);
        }

        prefixMap.put(prefixSum, prefixMap.get(prefixSum) - 1);
        prefixSum -= root.val;
    }
}
