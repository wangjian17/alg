package leetcode.normal.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class algDP514 {

    public int findRotateSteps(String ring, String key) {

        
        int n = ring.length();
        int m = key.length();

        // 存储字符和索引的映射
        HashMap<Character, LinkedList<Integer>> keysMapping = new HashMap<>();

        for (int i = 0; i < ring.length(); i++) {

            char ch = ring.charAt(i);
            if (!keysMapping.containsKey(ch)) {
                keysMapping.put(ch, new LinkedList<>());
            }

            keysMapping.get(ch).add(i);
        }
        
        // dp表示 当前指针为i 完成后m -j 个字符的最小数量
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        // 初始化
        for (int i = 0; i < n; i++) {

            // 当前的值和最近的那个比较
            for (int index : keysMapping.get(key.charAt(m - 1))) {
                // 距离
                int distance = Math.abs(index - i);
                // 顺时间和逆时针比较哪个短 拨动+1
                distance = Math.min(distance, n - distance) + 1;

                dp[i][m - 1] = Math.min(dp[i][m - 1], distance);
            }
        }

        // 遍历顺序一定是 先字符 后指针位置
        for (int j = m - 2; j >= 0; --j) {
            for (int i =0; i < n; ++i) {
                // 当前的值和最近的那个比较
                for (int index : keysMapping.get(key.charAt(j))) {
                    // 距离
                    int distance = Math.abs(index - i);
                    // 顺时间和逆时针比较哪个短 拨动+1
                    distance = Math.min(distance, n - distance) + 1;
                    // 状态转移： 从index位置转移
                    dp[i][j] = Math.min(dp[i][j], dp[index][j + 1] + distance);
                }
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args) {

        String ring = new String("godding");
        String key = new String("godding");

        System.out.println(new algDP514().findRotateSteps(ring, key));

    }
}
