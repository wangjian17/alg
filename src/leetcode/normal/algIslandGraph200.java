package leetcode.normal;

public class algIslandGraph200 {

    // '0'代表海水 '1'代表陆地
    // 两个全局变量 岛屿的图 和 visit数组
    char[][] grid;

    // 长宽
    int m;
    int n;

    int[][] direction;

    int result = 0;

    public int numIslands(char[][] grid) {

        this.grid = grid;

        m = grid.length;
        n = grid[0].length;

        direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是陆地，陆地数量+1，然后把陆地淹掉
                if (grid[i][j] == '1'){
                    ++result;
                    dfs(i,j);
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col) {

        // 先判断是否合法
        if (row < 0 || row >= m || col < 0 || col >= n){
            return;
        }

        // 如果是海水 直接返回
        if (grid[row][col] == '0') {
            return;
        }

        // 将陆地变成海水
        grid[row][col] = '0';

        // 遍历
        for (int[] ints : direction) {
            dfs(row + ints[0], col + ints[1]);
        }
    }
}
