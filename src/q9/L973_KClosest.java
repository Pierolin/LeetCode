package q9;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class L973_KClosest {
    /**
     * 方法一：调用 API 排序
     * TC: O(nlogn)
     * SC: O(logn)
     * 解题思路：
     * 1. 调用 API Arrays.sort() 方法
     * 2. 使用 Comparator
     */
    public int[][] kCloset(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);

        /**
         * lambda 写法如下：
         * Arrays.sort(points,(p1, p2)->((p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1])));
         * return Arrays.copyOfRange(points, 0, K);
         **/

        /**
         * 一行写法：
         * return Arrays.stream(points).sorted(Comparator.comparingInt((p) -> p[0] * p[0] + p[1] * p[1])).limit(K).toArray(int[][]::new);
         */
    }
}
