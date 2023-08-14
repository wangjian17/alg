package leetcode.normal;

import java.util.LinkedList;
import java.util.List;

public class algBacktracking140 {

    // 存放结果
    List<String> result;
    // 存放每条路径
    LinkedList<String> path;

    String src;

    List<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {

        result = new LinkedList<>();
        path = new LinkedList<>();
        src = s;
        dict = wordDict;

        backTracking(0);

        return result;
    }

    private void backTracking(int start) {

        // 成功
        if (start == src.length()) {
            result.add(new String(String.join(" ", path)));
            return;
        }

        for (String word : dict) {
            int end = start + word.length();
            if (end <= src.length() && src.substring(start, end).equals(word)){
                path.add(word);
                backTracking(end);
                path.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        String s =
                "pineapplepenapple";

        List<String> wordDict = List.of(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});


        List<String> strings = new algBacktracking140().wordBreak(s, wordDict);

    }
}
