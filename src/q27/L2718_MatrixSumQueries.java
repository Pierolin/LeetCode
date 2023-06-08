package q27;

import java.util.HashSet;
import java.util.Set;

/**
 * 2718. 查询后矩阵的和
 * Sum of Matrix After Queries
 * https://leetcode.cn/problems/sum-of-matrix-after-queries/
 */
public class L2718_MatrixSumQueries {
    /**
     * 方法一：倒序法
     * TC: O(q) 其中 qqq 为 queries 的长度
     * SC: O(min{q,n})
     */
    public long matrixSumQueries(int n, int[][] queries) {
        long sum = 0;
        Set<Integer> visRow = new HashSet<>();
        Set<Integer> visCol = new HashSet<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];
            if (q[0] == 0) {
                if (!visRow.contains(q[1])) {
                    sum += (long)q[2] * (n - visCol.size());
                    visRow.add(q[1]);
                }
            } else {
                if (!visCol.contains(q[1])) {
                    sum += (long)q[2] * (n - visRow.size());
                    visCol.add(q[1]);
                }
            }
        }
        return sum;
    }
}
