package interview;

/**
 * 面试题 01.08. 零矩阵
 * Zero Matrix
 * https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class I0108_SetZeroes {
    /**
     * 方法二：使用两个标记变量
     * TC: O(mn)，其中 m 是矩阵的行数，n 是矩阵的列数。
     * SC: O(1)
     */
    public void setZeroes_2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean is1stRowZero = false;
        boolean is1stColZero = false;
        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                is1stColZero = true;
                break;
            }
        }

        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) {
                is1stRowZero = true;
                break;
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) matrix[r][c] = 0;
            }
        }

        if (is1stColZero) {
            for (int r = 0; r < rows; r++) matrix[r][0] = 0;
        }

        if (is1stRowZero) {
            for (int c = 0; c < cols; c++) matrix[0][c] = 0;
        }
    }
    /**
     * 方法一： 使用标记数组
     * TC: O(mn)，其中 m 是矩阵的行数，n 是矩阵的列数。
     * SC: O(m+n)，其中 m 是矩阵的行数，n 是矩阵的列数。
     */
    public void setZeroes_1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowZeroes = new boolean[rows];
        boolean[] colZeroes = new boolean[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    rowZeroes[r] = true;
                    colZeroes[c] = true;
                }
            }
        }
        /*
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rowZeroes[r] || colZeroes[c]) matrix[r][c] = 0;
            }
        }
        */
        for (int r = 0; r < rows; r++) {
            if (rowZeroes[r]) {
                for (int c = 0; c < cols; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int c = 0; c < cols; c++) {
            if (colZeroes[c]) {
                for (int r = 0; r < rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
