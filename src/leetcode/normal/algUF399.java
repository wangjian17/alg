package leetcode.normal;

import java.util.HashMap;
import java.util.List;

public class algUF399 {

    // 用于判断变量是否存在以及与并查集的node id相互映射

    class UF{

        // 保存父亲节点
        int[] parent;
        // 保存与父亲节点的权重关系
        double[] weight;

        public UF(int n) {
            parent = new int[n];
            weight = new double[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        // a -> 2 -> b -> 4 -> c
        // a -> 8 ->  c
        private int find(int node) {
            // 在做路径压缩的时候 需要weight
            if (parent[node] != node) {
                // 找到最终的根节点
                int parentNode =parent[node];
                parent[node] = find(parent[node]);
                // 累乘法这条路径上的所有值
                weight[node] *= weight[parentNode];
            }

            return parent[node];
        }

        public double getWeight(int node1, int node2) {

            if (find(node1) == find(node2)){
                return weight[node1] / weight[node2];
            }else{
                return -1.0d;
            }
        }

        public void connect(int node1, int node2, double value) {

            int root1 = find(node1);
            int root2 = find(node2);

            if (root2 == root1) return;

            // 这里一定是改变 root1 的指向 而不是 node1 因为root1下面的整棵树都需要将根换一下
            parent[root1] = root2;
            // 这里的公式参考平行四边形法则
            weight[root1] = weight[node2] * value / weight[node1];
        }
    }

    HashMap<String, Integer> mappings;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int size = equations.size() * 2;

        UF uf = new UF(size);
        mappings = new HashMap<>(size);

        int count = 0;
        // 遍历每个元素
        for (int i = 0; i < equations.size(); ++i) {
            List<String> equation = equations.get(i);

            String fistSymbol = equation.get(0);
            String secondSymbol = equation.get(1);
            // 不存在映射关系就添加映射关系
            if (!mappings.containsKey(fistSymbol))
                mappings.put(fistSymbol, count++);
            if (!mappings.containsKey(secondSymbol))
                mappings.put(secondSymbol, count++);

            // 连接
            uf.connect(mappings.get(fistSymbol), mappings.get(secondSymbol), values[i]);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            List<String> query = queries.get(i);

            String firstQuery = query.get(0);
            String secondQuery = query.get(1);
            // 符号不存在 直接返回-1
            if (!mappings.containsKey(firstQuery) || !mappings.containsKey(secondQuery)){
                result[i] = -1d;
            }else {
                result[i] = uf.getWeight(mappings.get(firstQuery), mappings.get(secondQuery));
            }
        }

        return result;
    }
}
