package leetcode.acmtest;


import java.util.Scanner;

public class Solution6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int N = scanner.nextInt();

            for (int i = 0; i < N; i++) {

                int n = scanner.nextInt();
                int result = 0;

                for (int j = 0; j < n; j++) {
                    result += scanner.nextInt();
                }

                System.out.println(result);
                if (i != N - 1)
                    System.out.println();
            }
        }
    }
}
