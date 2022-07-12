package q12;

/**
 * 1252. 奇数值单元格的数目
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 */
public class L1252_OddCells {

    /**
     * 方法一：直接模拟
     * TC: O(q×(m+n)+m×n) 其中 q 表示数组 indices 的长度，m,n 为矩阵的行数与列数。
     * SC: O(m+n)
     */
    public int oddCells_1(int m, int n, int[][] indices) {
        if (m == 0 && n == 0) return 0;
        if (indices.length == 0) return 0;

        int[][] mn = new int[m][n];

        for (int[] indice : indices) {
            for (int c = 0; c < n; c++) mn[indice[0]][c]++;
            for (int r = 0; r < m; r++) mn[r][indice[1]]++;
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((mn[i][j] & 1) == 1) count++;
            }
        }

        return count;
    }


    /**
     * 方法二：模拟空间优化
     * TC: O(q+m×n) 其中 q 表示数组 indices 的长度，m,n 为矩阵的行数与列数。
     * SC: O(m+n)
     */
    public int oddCells_2(int m, int n, int[][] indices) {
        if (m == 0 && n == 0) return 0;
        if (indices.length == 0) return 0;

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] indice : indices) {
            rows[indice[0]]++;
            cols[indice[1]]++;
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) count++;
            }
        }

        return count;
    }

    /**
     * 方法三：计数优化
     * TC: O(q+m+n) 其中 q 表示数组 indices 的长度，m,n 为矩阵的行数与列数。
     * SC: O(m+n)
     */
    public int oddCells_3(int m, int n, int[][] indices) {
        if (m == 0 && n == 0) return 0;
        if (indices.length == 0) return 0;

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] indice : indices) {
            rows[indice[0]]++;
            cols[indice[1]]++;
        }

        int rowOddsCount = 0;
        int colOddsCount = 0;

        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) != 0) rowOddsCount++;
        }

        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) != 0) colOddsCount++;
        }

        return rowOddsCount * (n - colOddsCount) + colOddsCount * (m - rowOddsCount);
    }
}
