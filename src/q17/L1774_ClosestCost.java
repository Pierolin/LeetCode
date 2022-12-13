package q17;

import java.util.Arrays;

public class L1774_ClosestCost {
    /**
     * 方法一：回溯法
     * TC: O(n3^m)，其中 n，m 分别为数组 baseCosts，toppingCosts的长度
     * SC: O(m)
     */
    private int res;

    public int closestCost_1(int[] baseCosts, int[] toppingCosts, int target) {
        res = Arrays.stream(baseCosts).min().getAsInt();
        if (res >= target) return res;
        for (int baseCost : baseCosts) backTrack(toppingCosts, 0, baseCost, target);
        return res;
    }

    private void backTrack(int[] costs, int idx, int curCost, int target) {
        int curDiff = Math.abs(curCost - target);
        int resDiff = Math.abs(res - target);
        if (curCost - target > resDiff) return;
        if (curDiff < resDiff) res = curCost;
        if (curDiff == resDiff) res = Math.min(res, curCost);

        if (idx == costs.length) return;

        backTrack(costs, idx + 1, curCost, target);
        backTrack(costs, idx + 1, curCost + costs[idx], target);
        backTrack(costs, idx + 1, curCost + costs[idx] * 2, target);
    }

    /**
     * 方法二：动态规划
     * TC: O(target×m)
     * SC: O(target)
     */
    public int closestCost_2(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().getAsInt();
        if (min >= target) return min;

        int upper = 2 * target - min;
        boolean[] dp = new boolean[upper];
        for (int baseCost : baseCosts) {
            if (baseCost < upper) dp[baseCost] = true;
        }
        for (int toppingCost : toppingCosts) {
            for (int i = upper - 1; i >= min; i--) {
                if (dp[i] && (i + toppingCost < upper)) dp[i + toppingCost] = true;
                if (dp[i] && (i + toppingCost * 2 < upper)) dp[i + toppingCost * 2] = true;
            }
        }

        int ans = min;
        for (int i = min + 1; i < upper; i++) {
            if (dp[i]) {
                int curDiff = Math.abs(i - target);
                int ansDiff = Math.abs(ans - target);
                if (curDiff < ansDiff) {
                    ans = i;
                } else if (curDiff == ansDiff) {
                    ans = Math.min(ans, i);
                }
            }
        }
        return ans;
    }
}
