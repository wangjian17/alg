package leetcode.normal;

import java.util.LinkedList;
import java.util.Queue;

public class algBFS994 {


    private int m;
    private int n;
    int[][] grid;

    // 0 空 1新鲜 2腐烂
    public int orangesRotting(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        int[][] direction = new int[][]{{0, 1},{1, 0}, {0, -1}, {-1, 0}};

        this.grid = grid;

        Queue<int[]> queue = new LinkedList<>();

        int level = -1;

        // 需要找出所有腐烂的橘子添加到队列中 而不是 分别对每个腐烂的橘子做BFS操作
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] indexs = queue.poll();

                for (int[] dir : direction) {
                    int rowIndex = indexs[0] + dir[0];
                    int colIndex = indexs[1] + dir[1];

                    if (judge(rowIndex, colIndex)) {
                        queue.add(new int[]{rowIndex, colIndex});
                        // 状态改变为已腐烂
                        grid[rowIndex][colIndex] = 2;
                    }
                }
            }

            ++level;
        }

        // 再次遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(level, 0);
    }



    private boolean judge(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1;
    }


}
