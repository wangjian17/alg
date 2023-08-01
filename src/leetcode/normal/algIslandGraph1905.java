package leetcode.normal;

public class algIslandGraph1905 {

    // 1 陆地 0 水
    int m, n;
    int[][] grid1, grid2;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};;

    public int countSubIslands(int[][] grid1, int[][] grid2) {


        this.grid1 = grid1;
        this.grid2 = grid2;

        m = grid1.length;
        n = grid1[0].length;

        // 用grid1的水来淹没grid2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        int result = 0;
        // 找寻岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    ++result;
                    dfs(i, j);
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col) {
        // 判断是否合法
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        if (grid2[row][col] == 0) {
            return;
        }

        grid2[row][col] = 0;

        for (int[] direction: directions) {
            dfs(row + direction[0], col + direction[1]);
        }
    }


}
