package leetcode.normal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class algBFS752 {

    private String add(String str, int pos) {
        char[] chars = str.toCharArray();

        if (chars[pos] == '9') {
            chars[pos] = '0';
        }else{
            ++chars[pos];
        }

        return new String(chars);
    }

    private String sub(String str, int pos) {
        char[] chars = str.toCharArray();

        if (chars[pos] == '0') {
            chars[pos] = '9';
        }else{
            --chars[pos];
        }

        return new String(chars);
    }

    public int openLockBFS(String[] deadends, String target) {

        // 用于BFS遍历
        Queue<String> queue = new LinkedList<>();
        // 使用哈希表快速判断是否死亡
        HashSet<String> hashSet = new HashSet<>(List.of(deadends));

        queue.add("0000");

        // 去重集合
        HashSet<String> visit = new HashSet<>();
        visit.add("0000");

        int number = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String str = queue.poll();

                // 到达终点
                if (target.equals(str)) {
                    return number;
                }

                // 遇到死亡节点
                if (hashSet.contains(str)) {
                    continue;
                }

                // 八种调整的方式
                for (int j = 0; j < 4; j++) {
                    String addStr = add(str, j);
                    if (!visit.contains(addStr)){
                        queue.add(addStr);
                        visit.add(addStr);
                    }


                    String subStr = sub(str, j);
                    if (!visit.contains(subStr)){
                        queue.add(subStr);
                        visit.add(subStr);
                    }
                }

            }

            ++number;
        }

        return -1;
    }

    public int openLock(String[] deadends, String target) {

        // 用于BFS遍历 这里需要使用哈希表
        HashSet<String> queue = new HashSet<>();
        HashSet<String> queue2= new HashSet<>();

        // 使用哈希表快速判断是否死亡
        HashSet<String> hashSet = new HashSet<>(List.of(deadends));

        queue.add("0000");
        queue2.add(target);

        // 去重集合
        HashSet<String> visit = new HashSet<>();
        visit.add("0000");

        int number = 0;

        while (!queue.isEmpty() && !queue2.isEmpty()) {

            HashSet<String> temp = new HashSet<>();


            for (String str:queue) {
                // 到达终点
                if (queue2.contains(str)) {
                    return number;
                }

                // 遇到死亡节点
                if (hashSet.contains(str)) {
                    continue;
                }

                visit.add(str);

                // 八种调整的方式
                for (int j = 0; j < 4; j++) {
                    String addStr = add(str, j);
                    if (!visit.contains(addStr)){
                        temp.add(addStr);
                    }


                    String subStr = sub(str, j);
                    if (!visit.contains(subStr)){
                        temp.add(subStr);
                    }
                }
            }

            ++number;
            queue = queue2;
            queue2 = temp;

        }

        return -1;
    }
}
