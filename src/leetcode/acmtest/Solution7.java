package leetcode.acmtest;

import java.util.HashMap;
import java.util.Scanner;

public class Solution7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> exists = new HashMap<>();
        exists.put("A", 4);
        exists.put("B", 3);
        exists.put("C", 2);
        exists.put("D", 1);
        exists.put("F", 0);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");

            int i;
            double result = 0;
            for (i = 0; i < strings.length; i++) {
                if (exists.containsKey(strings[i])) {
                    result += exists.get(strings[i]);
                }else {
                    break;
                }
            }

            if (i == strings.length){
                System.out.println(String.format("%.2f", result / i));
            }else {
                System.out.println("Unknown");
            }

        }
    }
}
