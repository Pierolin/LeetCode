import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L57_Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        if (newInterval == null || newInterval.length == 0) return intervals;

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

        int[][] result = insert.insert(intervals, newInterval);
        for (int[] inv : result) System.out.println(Arrays.toString(inv));
    }
}
