package leetcode.normal;


import leetcode.datastruct.UF;

public class algUF116 {
    public int findCircleNum(int[][] isConnected) {

        int size = isConnected.length;
        // 声明UF对象
        UF uf = new UF(size);

        // 将节点连接
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isConnected[i][j] == 1) {
                    uf.connect(i,j);
                }
            }
        }

        return uf.getCount();
    }
}
