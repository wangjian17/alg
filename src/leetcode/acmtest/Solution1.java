package leetcode.acmtest;

import java.util.Scanner;

public class Solution1 {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b;
        while(scanner.hasNextInt()){

            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println(a + b);
        }
    }
}
