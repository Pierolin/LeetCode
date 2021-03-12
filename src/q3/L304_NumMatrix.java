package q3;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
public class L304_NumMatrix {
    int[][] sums;
    public L304_NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        sums = new int[rows][cols];
        int lastSum = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sums[r][c] = lastSum + matrix[r][c];
                lastSum = sums[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            sum += sums[r][col2] - (col1 > 0 ? sums[r][col1 - 1] : (r > 0 ? sums[r - 1][sums[0].length - 1] : 0));
        }
        return sum;
    }
}
