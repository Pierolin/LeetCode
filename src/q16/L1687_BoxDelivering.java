package q16;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 1687. 从仓库到码头运输箱子
 * Delivering Boxes from Storage to Ports
 * https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/description/
 */
public class L1687_BoxDelivering {

    /**
     * 方法四：优先队列 (思想同方法三一致)
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int dp = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int diff = 0;
        int wei = 0;
        for (int i = 1; i <= boxes.length; i++) {
            diff += (i > 1 && boxes[i - 1][0] != boxes[i - 2][0]) ? 1 : 0;
            int curr = dp + 2 - diff;
            q.add(new int[]{i, curr, -wei});
            wei += boxes[i - 1][1];
            while (q.peek()[0] <= i - maxBoxes || q.peek()[2] + wei > maxWeight) q.poll();
            dp = q.peek()[1] + diff;
        }
        return dp;
    }

    /**
     * 方法三：动态规划优化(优化空间) + 单调队列 (优化方法二)
     * TC: O(n)
     * SC: O(1)
     */
    public int boxDelivering_3(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int dp = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int diff = 0;
        int wei = 0;
        for (int i = 1; i <= boxes.length; i++) {
            diff += (i > 1 && boxes[i - 1][0] != boxes[i - 2][0]) ? 1 : 0;
            int curr = dp + 2 - diff;
            while (!q.isEmpty() && q.peekLast()[1] >= curr) q.pollLast();
            q.add(new int[]{i, curr, -wei});
            wei += boxes[i - 1][1];
            while (q.peekFirst()[0] <= i - maxBoxes || q.peekFirst()[2] + wei > maxWeight) q.pollFirst();
            dp = q.peekFirst()[1] + diff;
        }
        return dp;
    }

    /**
     * 方法二：动态规划 + 单调队列 (优化方法一)
     * TC: O(n)
     * SC: O(n)
     */
    public int boxDelivering_2(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int diff = 0;
        int wei = 0;
        for (int i = 1; i <= n; i++) {
            diff += (i > 1 && boxes[i - 1][0] != boxes[i - 2][0]) ? 1 : 0;
            int curr = dp[i - 1] + 2 - diff;
            while (!q.isEmpty() && q.peekLast()[1] >= curr) q.pollLast();
            q.add(new int[]{i, curr, -wei});
            wei += boxes[i - 1][1];
            while (q.peekFirst()[0] <= i - maxBoxes || q.peekFirst()[2] + wei > maxWeight) q.pollFirst();
            dp[i] = q.peekFirst()[1] + diff;
        }
        return dp[n];
    }

    /**
     * 方法一：动态规划 (超时)
     * TC: O(n^3)
     * SC: O(n)
     */
    public int boxDelivering_1(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j > 0 && j > i - maxBoxes; j--) {
                sum += boxes[j - 1][1];
                if (sum > maxWeight) break;
                dp[i] = Math.min(dp[i], dp[j - 1] + cost(boxes, j, i));
            }
        }
        return dp[n];
    }

    int cost(int[][] boxes, int left, int right) {
        int ans = 2;
        for (int i = left; i < right; i++) {
            if (boxes[i][0] != boxes[i - 1][0]) ans++;
        }
        return ans;
    }
}
