package leetcode.normal;

import static java.lang.Math.max;

public class algIslandGraph695 {

    int m, n;
    int[][] grid;
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 0 水 1 陆地
    public int maxAreaOfIsland(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = dfs(i, j);
                result = max(num, result);
            }
        }

        return result;
    }

    private int dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }

        if (grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        int result = 1;
        for (int[] direct:direction) {
            result += dfs(row + direct[0], col + direct[1]);
        }

        return result;
    }

}
