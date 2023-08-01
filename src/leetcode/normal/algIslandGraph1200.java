package leetcode.normal;

public class algIslandGraph1200 {

    int[][] grid;
    int m, n;

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 0 是海洋 1是陆地
    public int numEnclaves(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        // 四周先淹没
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
            dfs(i, n -1);
        }

        int result = 0;
        // 计算数量
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1){
                    ++result;
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

        // 海洋就算了
        if (grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        for (int[] direct: direction) {
            dfs(row + direct[0], col + direct[1]);
        }
    }
}
