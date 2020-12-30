package q1;

/**
 * 134. 加油站
 * https://leetcode-cn.com/problems/gas-station/
 */
public class L134_CanCompleteCircuit {
    /**
     * 方法：暴力循环
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 暴力循环
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int gases = 0;
            int costs = 0;
            for (int j = i; (j < len || j < i); j++) {
                gases += gas[j];
                costs += cost[j];
                if (gases < costs) break;
                if (j == len - 1) {
                    if (i == 0) return 0;
                    j = -1;
                    continue;
                }
                if (j == i - 1) return i;
            }
            /*
            for (int j = i; j < len; j++) {
                gases += gas[j];
                costs += cost[j];
                if (gases < costs) break;
                if (j == len - 1) {
                    if (i == 0) return i;
                    for (int n = 0; n < i; n++) {
                        gases += gas[n];
                        costs += cost[n];
                        if (gases < costs) break;
                        if (n == i - 1) return i;
                    }
                }
            }
            */
        }
        return -1;
    }
}
