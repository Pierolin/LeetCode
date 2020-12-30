package q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L57_Insert {
    /**
     * 方法一：
     * TC: O(n)
     * SC: O(1)
     * 解题思路
     */
    public int[][] insert_1(int[][] intervals, int[] newInterval) {
        if (intervals == null ) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        if (newInterval == null ) return intervals;

        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        // insert less
        while ( i < intervals.length && newInterval[0] > intervals[i][1]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        // merge cross
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // add the merged interval
        mergedIntervals.add(newInterval);
        // insert more
        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    /**
     * 方法二：
     * TC: O(n)
     * SC: O(1)
     * 解题思路
     */
    public int[][] insert_2(int[][] intervals, int[] newInterval) {
        int is = newInterval[0];
        int ie = newInterval[1];
        List<int[]> list = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] item = intervals[i];
            int s = item[0];
            int e = item[1];

            // left out the current interval
            if (ie < s) {
                int[] interval = {is, ie};
                list.add(interval);
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                inserted = true;
                break;
            }
            // left join or cross the current interval
            if (is <= s && ie <= e) {
                int[] interval = {is, e};
                list.add(interval);
                for (int j = i + 1; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                inserted = true;
                break;
            }
            // in the current interval
            if (is >= s && ie <= e) {
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                inserted = true;
                break;
            }

            // right join or cross the current interval
            if (is >= s && is <= e && ie > e) {
                is = s;
                continue;
            }

            // contain the current interval
            if (is < s && ie > e) {
                continue;
            }

            // right out the current interval
            if (is > e) {
                int[] interval = {s, e};
                list.add(interval);
            }
        }

        if (!inserted) {
            int[] interval = {is, ie};
            list.add(interval);
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        L57_Insert insert = new L57_Insert();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = insert.insert_1(intervals, newInterval);
        for (int[] inv : result) System.out.println(Arrays.toString(inv));
    }
}
