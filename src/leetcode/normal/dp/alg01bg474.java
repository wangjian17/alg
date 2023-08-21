package leetcode.normal.dp;

public class alg01bg474 {

    public int findMaxForm(String[] strs, int m, int n) {

        int length = strs.length;

        int[][] arr = new int[length][2];

        for (int i = 0; i < length; i++) {
            int zeros = 0;
            int ones = 0;


            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    ++zeros;
                }else{
                    ++ones;
                }
            }

            arr[i][0] = zeros;
            arr[i][1] = ones;
        }

        int dp[][] = new int[m + 1][n + 1];

        for (int[] num : arr) {

            for (int i = m; i >= num[0]; i--) {
                for (int j = n; j >= num[1]; j--) {

                    dp[i][j] = Math.max(dp[i][j], dp[i - num[0]][j - num[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
