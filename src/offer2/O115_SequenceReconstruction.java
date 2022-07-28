package offer2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 剑指 Offer II 115. 重建序列
 * https://leetcode.cn/problems/ur2n8P/
 */
public class O115_SequenceReconstruction {
    /**
     * 方法一： 拓扑排序
     * TC: O(n+m)
     * SC: O(n+m)
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        if (nums == null || sequences == null) return false;
        if (nums.length == 0 || sequences.length == 0) return false;

        int len = nums.length;
        // record in degrees and generate graph
        int[] inDegrees = new int[len + 1];
        Set<Integer>[] points = new Set[len + 1];
        for (int i = 1; i <= len; i++) points[i] = new HashSet<Integer>();

        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int from = sequence[i - 1];
                int to = sequence[i];
                if (points[from].add(to)) {
                    inDegrees[to]++;
                }
            }
        }

        // save 0 in degree into a queue
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= len; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        // loop the queque
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int i = queue.poll();
            for (int to : points[i]) {
                inDegrees[to]--;
                if (inDegrees[to] == 0) queue.offer(to);
            }
        }

        return true;
    }
}
