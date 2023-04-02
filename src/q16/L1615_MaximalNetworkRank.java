package q16;

public class L1615_MaximalNetworkRank {
    /**
     * 方法一：枚举遍历 + 邻接矩阵
     * TC: O(n^2)
     * SC: O(n^2)
     */
    public int maximalNetworkRank_1(int n, int[][] roads) {
        int[][] conns = new int[n][n];
        int[] counts = new int[n];
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            conns[a][b] = 1;
            conns[b][a] = 1;
            counts[a]++;
            counts[b]++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max (max, counts[i] + counts[j] - conns[i][j]);
            }
        }
        return max;
    }
}
