package leetcode.acmtest;

import java.util.Scanner;

public class Solution9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            // 读取每一位
            int result = 0;

            while (n > 0){
                // 取出最后一位
                int num = n % 10;
                if (num % 2 == 0) {
                    result += num;
                }

                n = n / 10;
            }

            System.out.println(result);
            System.out.println();
        }
    }
}
