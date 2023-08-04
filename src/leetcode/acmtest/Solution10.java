package leetcode.acmtest;

import java.util.Scanner;

public class Solution10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int M = scanner.nextInt();
            int K = scanner.nextInt();

            if (M == 0 && K == 0) break;

            int result = M;

            while (M >= K){
                result += M / K;
                M = M % K + M / K;
            }

            System.out.println(result);
        }
    }
}
