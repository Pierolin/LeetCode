import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class L452_FindMinArrowShots {
    /**
     * 排序比较法
     * Time: O(nlogn)
     * Space: O(1)
     * 解题思路：
     * 1. 对数组进行排序;
     * 2.
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return p1[1] > p2[1] ? 1 : -1;
            }
        });
        // 另 2 种排序写法
        // Arrays.sort(points,(p1, p2) -> p1[1] > p2[1] ? 1 : -1);
        // Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));

        int count = 1;
        int right = points[0][1];

        for (int[] point : points) {
            if (point[0] > right) {
                count++;
                right = point[1];
            }
        }

        return count;

    }

}
