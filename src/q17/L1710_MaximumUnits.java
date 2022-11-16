package q17;

import java.util.Arrays;

public class L1710_MaximumUnits {
    /**
     * 方法一：贪心数组
     * TC: O(n)
     * SC: O(1)
     */
    public int maximumUnits_2(int[][] boxTypes, int truckSize) {
        int max = 0;
        int[] bts = new int[1001];
        for (int[] bt : boxTypes) bts[bt[1]] += bt[0];
        for (int i = bts.length - 1; i > 0; i--) {
            if (bts[i] >= truckSize) return max + truckSize * i;
            max += i * bts[i];
            truckSize -= bts[i];
        }
        return max;
    }

    /**
     * 方法一：贪心排序
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int maximumUnits_1(int[][] boxTypes, int truckSize) {
        int max = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] bt : boxTypes) {
            if (truckSize <= bt[0]) return max + truckSize * bt[1];
            max += bt[0] * bt[1];
            truckSize -= bt[0];
        }
        return max;
    }
}
