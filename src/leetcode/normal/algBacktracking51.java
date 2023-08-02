package leetcode.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class algBacktracking51 {

    List<List<String>> result;
    // 路径
    ArrayList<String> path;



    // 两种一个是'.' 'Q'

    // 判断是否符合规则
    private boolean judge(int row, int col, int n){

        // 同一行已经自动判断了
        // 只需要判断列
        for (int i = 0; i < row; i++) {
            if (path.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        // 左斜
        for (int i = 1; i <= row && i <= col; i++) {
            if (path.get(row - i).charAt(col - i) == 'Q'){
                return false;
            }
        }

        // 右斜
        for (int i = 1; i <= row && i + col < n; i++) {
            if (path.get(row - i).charAt(col + i) == 'Q') {
                return false;
            }
        }

        return true;
    }


    public List<List<String>> solveNQueens(int n) {

        // 初始化
        result = new LinkedList<>();
        path = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            path.add(".".repeat(n));
        }

        backtracking(n, 0);

        return result;
    }

    private void backtracking(int n, int row) {

        // 终止条件
        if (row == n){
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (judge(row, col, n)){
                // 做选择
                char[] chars = path.get(row).toCharArray();
                chars[col] = 'Q';
                path.set(row, new String(chars));

                backtracking(n, row + 1);
                // 撤销选择
                path.set(row, ".".repeat(n));

            }
        }
    }

}
