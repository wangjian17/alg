package leetcode.normal;

public class alg392 {

    public boolean isSubsequence(String s, String t) {

        int slow = 0;

        for (int i = 0; i < t.length(); i++) {
            if (slow == s.length()) return true;
            if (t.charAt(i) == s.charAt(slow)) {
                ++slow;
            }
        }

        if (slow == s.length()) return true;
        return false;
    }
}
