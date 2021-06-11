package q3;

import java.util.TreeSet;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class L363_MaxSumSubmatrix {
    /**
     * 方法二：
     * Time: O( )
     * Space: O( )
     */
    public int maxSumSubmatrix_2(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }

    /**
     * 方法一：前缀和 + 暴力枚举所有矩形和
     * Time: O(m*n + m^2*n^2)
     * Space: O(m*n)
     * 解题思路：
     * 1. 使用二维前缀和
     * 2. 暴力板举所有矩形
     */
    public int maxSumSubmatrix_1(int[][] matrix, int k) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;

        // 1. 计算前缀和
        int[][] preSum = new int[rows + 1][cols + 1];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                preSum[r + 1][c + 1] = preSum[r][c + 1] + preSum[r + 1][c] - preSum[r][c] + matrix[r][c];
            }
        }
        // 2. 暴力枚举所有矩形的和, 取小于等于 k 的最大值
        int max = Integer.MIN_VALUE;
        for (int x1 = 0; x1 < rows; x1++) {
            for (int y1 = 0; y1 < cols; y1++) {
                for (int x2 = x1; x2 < rows; x2++) {
                    for (int y2 = y1; y2 < cols; y2++) {
                        int sum = preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
                        if (sum <= k) max = Integer.max(max, sum);
                    }
                }
            }
        }

        return max;
    }
}
