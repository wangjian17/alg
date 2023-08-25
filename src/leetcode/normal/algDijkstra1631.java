package leetcode.normal;

import java.util.*;

public class algDijkstra1631 {

    class Node{
        int row;
        int col;

        int minValue;


        public Node(int row, int col, int minValue) {
            this.row = row;
            this.col = col;
            this.minValue = minValue;
        }
    }


    int[][] minValues;

    int m, n;




    public int minimumEffortPath(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        minValues = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minValues[i], Integer.MAX_VALUE);
        }
        minValues[0][0] = 0;

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.minValue - o2.minValue;
            }
        });

        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            // 提前截止
            if (node.row == m - 1 && node.col == n - 1) {
                return minValues[m - 1][n - 1];
            }

            LinkedList<Node> nextList = adjust(node, heights);
            for (Node next: nextList) {
                queue.add(next);
            }
        }

        return minValues[m - 1][n - 1];
    }

    private LinkedList<Node> adjust(Node node, int[][] heights) {

        int row = node.row;
        int col = node.col;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        LinkedList<Node> list = new LinkedList<>();

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                continue;
            }

            // 计算差值
            int value = Math.max(Math.abs(heights[row][col] - heights[nextRow][nextCol]), node.minValue);
            if ( value < minValues[nextRow][nextCol]) {
                list.add(new Node(nextRow, nextCol, value));
                minValues[nextRow][nextCol] = value;
            }
        }

        return list;
    }


}
