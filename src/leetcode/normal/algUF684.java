package leetcode.normal;

public class algUF684 {

    class UF{
        private int count;
        private int[] parent;

        public UF(int[][] edges){

            int size = edges.length;
            parent = new int[size + 1];

            for (int i = 1; i <= size; i++) {
                parent[i] = i;
            }


        }

        private int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public void union(int node1, int node2) {

            int root1 = find(node1);
            int root2 = find(node2);

            if (root2 == root1) return;

            parent[root1] = root2;

            --count;
        }

        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        public int getCount() {
            return count;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

        UF uf = new UF(edges);

        // 构建
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (uf.isConnected(node1, node2)) {
                return edge;
            }

            uf.union(node1, node2);
        }

        return new int[]{};
    }

}
