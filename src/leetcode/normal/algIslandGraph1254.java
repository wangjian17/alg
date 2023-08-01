package leetcode.normal;

public class algIslandGraph1254 {

    int m, n;
    int[][] grid;
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 0 陆地 1 海洋
    public int closedIsland(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        // 先将四周的岛屿淹没
        for (int i = 0; i < n; i++) {
            dfs(0, i);
        }

        for (int i = 0; i < n; i++) {
            dfs(m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1);
        }

        int result = 0;
        // 计算岛屿数量
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0){
                    ++result;
                    dfs(i, j);
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col) {
        // 首先判断是否合法
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        // 如果是海洋就算了
        if (grid[row][col] == 1) {
            return;
        }

        // 淹没
        grid[row][col] = 1;
        // 遍历
        for (int[] ints : direction) {
            dfs(row + ints[0], col + ints[1]);
        }
    }
}
