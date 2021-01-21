package q4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class L435_EraseOverlapIntervals {
    /**
     * 方法一：贪心算法
     * Time: O(nlogn)
     * Space: O(logn)
     * 解题思路：
     * 1. 按区间的右端点小大对区间数组进行排序;
     * 2. 以最小右端点为标杆点，遍历各区间，如果某一区间的左端点 >= 标杆点，则保留该区间并更新标杆, 如果 < 标杆点, 则去除该区间。
     */
    public int eraseOverIntervals(int[][] intervals) {
        if (intervals == null) return 0;
        int len = intervals.length;
        if (len < 2) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
        // lambda expression
        // Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int flag = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= flag) {
                flag = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
