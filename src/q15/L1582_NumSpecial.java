package q15;

/**
 * 1582. 二进制矩阵中的特殊位置
 * Special Positions in a Binary Matrix
 * https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
 */
public class L1582_NumSpecial {
    /**
     * 方法二：模拟
     * TC: O(n)
     * SC: O(n)
     */
    public int numSpecial_2(int[][] mat) {
        int count = 0;
        int row = mat.length;
        int col = mat[0].length;
        int[] rowCounts = new int[row];
        int[] colCounts = new int[col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (mat[r][c] == 1) {
                    rowCounts[r]++;
                    colCounts[c]++;
                }
            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (mat[r][c] == 1 && rowCounts[r] == 1 && colCounts[c] == 1) count++;
            }
        }
        return count;
    }

    /**
     * 方法一：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public int numSpecial_1(int[][] mat) {
        int count = 0;
        int row = mat.length;
        int col = mat[0].length;
        outer:
        for (int r = 0; r < row; r++) {
            int sumRow = 0;
            int col1 = -1;
            for (int c = 0; c < col; c++) {
                sumRow += mat[r][c];
                if (sumRow > 1) continue outer;
                if (mat[r][c] == 1) col1 = c;
            }
            if (sumRow == 1) {
                int sumCol = 0;
                for (int n = 0; n < row; n++) {
                    sumCol += mat[n][col1];
                    if (sumCol > 1) continue outer;
                }
                if (sumCol == 1) count++;
            }
        }
        return count;

    }
}
