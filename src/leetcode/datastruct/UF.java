package leetcode.datastruct;



// 表示并查集的类
public class UF {
    // 连通分支的数量
    private int count;

    private int[] parent;

    public UF(int count) {
        this.count = count;
        this.parent = new int[count];

        // 初始化自己的根节点是自己
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }


    // find函数 找到根节点
    public int find(int node){
        // 表示还没有到根节点
        if (parent[node] != node) {
            // 父亲节点该变了
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    public void connect(int node1, int node2) {
        // 找到根节点
        int root1 = find(node1);
        int root2 = find(node2);

        // 表示已经连接
        if (root1 == root2) return;

        parent[root2] = root1;

        // 连通分量减少
        --count;
    }

    public boolean isConnect(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public int getCount() {
        return count;
    }
}
