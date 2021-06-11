package q3;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */

/**
 * 方法三：二维前缀和法
 * Time: 初始化 O(m*n); 后续调用 O(n)
 * Space: O(m*n)
 * 解题思路：
 * 1.
 */

public class L304_NumMatrix {
    private int[][] preSum;

    public L304_NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        preSum = new int[rows + 1][cols + 1];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                preSum[r + 1][c + 1] = preSum[r][c + 1] + preSum[r + 1][c] - preSum[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}

/**
 * 方法二：一维前缀和法
 * Time: 初始化 O(m*n); 后续调用 O(n)
 * Space: O(m*n)
 * 解题思路：
 * 1. 生成一维前缀和 sums;
 * 2. 分别计算矩形每一行的和，再累加每和的和;
 * 3. 注意处理 row = 0, col = 0 边界问题。
 * <p>
 * 方法一：暴力法
 * Time: O(m*n)
 * Space: O(1)
 */

/*
public class L304_NumMatrix {
    int[][] preSums;
    public L304_NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        preSums = new int[rows][cols];
        int lastSum = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                preSums[r][c] = lastSum + matrix[r][c];
                lastSum = preSums[r][c];
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
*/

/**
 * 方法一：暴力法
 * Time: O(m*n)
 * Space: O(1)
 */
/*
class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }
}
 */
