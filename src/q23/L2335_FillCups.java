package q23;

import java.util.Arrays;

/**
 * 2335. 装满杯子需要的最短总时长
 * Minimum Amount of Time to Fill Cups
 * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups
 */
public class L2335_FillCups {

    /**
     * 方法二：排序
     * TC: O(max(amount[i]))
     * SC: O(1)
     */
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int seconds = 0;
        while (amount[1] > 0) {
            seconds++;
            amount[1]--;
            amount[2]--;
            Arrays.sort(amount);
        }
        seconds += amount[2];
        return seconds;
    }

    /**
     * 方法二：贪心 + 排序
     * TC: O(1)
     * SC: O(1)
     */
    public int fillCups_2(int[] amount) {
        Arrays.sort(amount);
        int diff = amount[0] + amount[1] - amount[2];
        if (diff <= 0) {
            return amount[2];
        } else {
            return amount[2] + (diff + 1) / 2;
        }
    }
}
