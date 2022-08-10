package q6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 * Exclusive Time of Functions
 * https://leetcode.cn/problems/exclusive-time-of-functions/
 */
public class L636_ExclusiveTime {
    /**
     * 方法一：棧
     * TC: O(n)
     * SC: O(n)
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];
        if(n < 1 || logs == null || logs.size() == 0) return times;

        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] items = log.split(":");
            int id = Integer.parseInt(items[0]);
            String status = items[1];
            int time = Integer.parseInt(items[2]);

            if (status.equals("start")) {
                stack.push(new int[]{id, time});
            } else {
                int[] start = stack.pop();

                int diff = time - start[1] + 1;
                times[id] += diff;
                if (!stack.isEmpty()) {
                    times[stack.peek()[0]] -= diff;
                }
            }
        }

        return  times;
    }
}
