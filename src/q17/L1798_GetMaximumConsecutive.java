package q17;

import java.util.Arrays;

public class L1798_GetMaximumConsecutive {
    /**
     * 方法一：贪心法
     * TC: O(nlogn)
     * SC: O(logn)
     */
    public int getMaximumConsecutive(int[] coins) {
        int max = 1;
        Arrays.sort(coins);
        for (int c : coins) {
            if (c > max) break;
            max += c;
        }
        return max;
    }
}
