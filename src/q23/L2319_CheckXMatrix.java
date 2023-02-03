package q23;

/**
 * 2319. 判断矩阵是否是一个 X 矩阵
 * Check if Matrix Is X-Matrix
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 */
public class L2319_CheckXMatrix {
    /**
     * 方法一：模拟法
     * TC: O(n^2)
     * SC: O(1)
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int num = grid[r][c];
                if (r == c || r + c == n - 1) {
                    if (num == 0) return false;
                } else {
                    if (num != 0) return false;
                }
                // 如下为一行简略写法
                // if ((grid[r][c] == 0) == (r == c || r + c == n - 1)) return false;
            }
        }
        return true;
    }
}
