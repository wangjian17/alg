package leetcode.normal;

import java.util.Arrays;
import java.util.Comparator;

public class algUF990 {

    private class UF{

        int count;
        int[] parent;

        public UF() {

            count = 26;
            parent = new int[count];

            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        private int find(int node){
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public void connect(char node1, char node2) {

            int root1 = find(node1 - 'a');
            int root2 = find(node2 - 'a');

            if (root1 == root2) return;

            parent[root2] = root1;

            --count;
        }

        public boolean isConnected(char node1, char node2) {

            return find(node1 - 'a') == find(node2 - 'a');
        }

        public int getCount() {
            return count;
        }
    }
    public boolean equationsPossible(String[] equations) {

        UF uf = new UF();


        // == 放在前面
        Arrays.sort(equations, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                char symbol1 = o1.charAt(1);
                char symbol2 = o2.charAt(1);

                if (symbol1 == '=' && symbol2 == '!') {
                    // 在前面的是-1
                    return -1;
                } else if (symbol1 == '!' && symbol2 == '=') {
                    return 1;
                } else {
                    return o1.charAt(0) - o2.charAt(0);
                }

            }
        });

        for (String equation : equations) {
            char node1 = equation.charAt(0);
            char node2 = equation.charAt(3);

            char symbol = equation.charAt(1);

            if (symbol == '!' && uf.isConnected(node1, node2)) {
                return false;
            }else if (symbol == '='){
                uf.connect(node1, node2);
            }

        }

        return true;
    }
}
