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

    /**
     * 方法三：三进制暴力枚举
     * TC: O(n * m ^ 3 * log(3,m))
     * SC: O(1)
     */

    public int closestCost_3(int[] baseCosts, int[] toppingCosts, int target) {
        int closestCost = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int baseCost : baseCosts) {
            for (int i = 0; i < Math.pow(3, toppingCosts.length); i++) {
                int cost = baseCost + toppingCost(i, toppingCosts);
                int diff = Math.abs(cost - target);
                if (diff == 0) return cost;
                if (diff > minDiff) continue;
                if (diff < minDiff) {
                    closestCost = cost;
                    minDiff = diff;
                } else {
                    closestCost = Math.min(closestCost, cost);
                }
            }
        }
        return closestCost;
    }

    private int toppingCost(int n, int[] costs) {
        int sum = 0;
        int i = 0;
        while (n > 0) {
            sum += costs[i++] * (n % 3);
            n /= 3;
        }
        return sum;
    }
}
