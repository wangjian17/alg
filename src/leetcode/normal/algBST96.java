package leetcode.normal;

public class algBST96 {




    public int numTreesForRecursion(int n) {

        if (n == 0 || n == 1) return 1;

        // 通过递归 将问题分解
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += numTrees(i) * numTrees(n - 1 - i);
        }

        return result;
    }

    public int numTrees(int n) {

        // 递归方法的时间复杂度优点高
        // 通过添加DP数组来解决这个问题
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new algBST96().numTrees(3));
    }

}
