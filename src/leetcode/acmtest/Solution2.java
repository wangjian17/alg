package leetcode.acmtest;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                int a, b;
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println(a + b);
            }
        }


    }

}
