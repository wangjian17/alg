package leetcode.acmtest;

import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            if (n == 0) break;
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += scanner.nextInt();
            }
            System.out.println(result);
        }
    }
}
