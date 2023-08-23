package leetcode.normal;

import java.util.LinkedList;
import java.util.List;

public class algBacktracking22 {

    List<String> result;

    StringBuilder path;


    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();

        path = new StringBuilder();

        backTracking(0,0,n);

        return result;
    }

    private void backTracking(int left, int right, int n) {

        if (right == n) {
            if (left == right)
                result.add(path.toString());
            return;
        }

        if (left == n + 1) {
            return;
        }

        path.append('(');
        backTracking(left + 1, right, n);
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        backTracking(left, right + 1, n);
        path.deleteCharAt(path.length() - 1);


    }

}
