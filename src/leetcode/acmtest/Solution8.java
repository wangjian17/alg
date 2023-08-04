package leetcode.acmtest;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;

            ArrayList<Integer> list = new ArrayList<>();
            list.ensureCapacity(n);
            int result = 0;

            for (int i = 0; i < n; i++) {
                list.add( scanner.nextInt());
                result += list.get(i);
            }

            result /= n;

            int num = 0;
            for (Integer integer : list) {
                num += Math.abs(integer - result);
            }

            System.out.println(num / 2);
            System.out.println();
        }
    }
}
