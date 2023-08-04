package leetcode.acmtest;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }else {
                System.out.println(a + b);
            }
        }

    }
}
