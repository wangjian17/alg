package leetcode.normal;

import java.util.HashSet;

public class algIslandGraph694 {

    int m,n;
    int[][] grid;
    HashSet<String> set;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    int numDistinctIslands(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        set = new HashSet<>();


        // 使用方向序列化 唯一
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    // 初始方向不影响随便加
                    dfs(i, j, builder, 666);
                    if (!set.contains(builder.toString())) {
                        ++result;
                    }
                    set.add(builder.toString());
                }
            }
        }

        return result;

    }

    private void dfs(int row, int col, StringBuilder builder, int dir) {

        // 不合法
        if (row < 0 || row >= m || col < 0 || col >= n|| grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        // 添加
        builder.append(dir).append(",");


        int count = 0;
        for (int[] direction: directions) {
            dfs(row +direction[0], col + direction[1], builder, ++count);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0,0, 0, 1, 1},
                {0,0, 0, 1, 1},
        };

        System.out.println(new algIslandGraph694().numDistinctIslands(grid));

    }
}
