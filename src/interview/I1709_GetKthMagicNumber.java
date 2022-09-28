package interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数
 * Get Kth Magic Number LCCI
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/
 */
public class I1709_GetKthMagicNumber {
    /**
     * 方法二：动态规划
     * TC: O(n)
     * SC: O(n)
     */
    public int getKthMagicNumber(int k) {
        int[] magics = new int[k];
        magics[0] = 1;
        int i3 = 0;
        int i5 = 0;
        int i7 = 0;
        for (int i = 1; i < k; i++) {
            int min = Math.min(Math.min(magics[i3] * 3, magics[i5] * 5), magics[i7] * 7);
            magics[i] = min;
            if (min == magics[i3] * 3) i3++;
            if (min == magics[i5] * 5) i5++;
            if (min == magics[i7] * 7) i7++;
        }
        return magics[k - 1];
    }

    /**
     * 方法一：优先队列（堆）
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int getKthMagicNumber_1(int k) {
        int[] factors = {3, 5, 7};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> dict = new HashSet<>();
        heap.offer(1L);
        while (true) {
            Long num = heap.poll();
            if (!dict.contains(num)) {
                if (dict.size() == k - 1) return num.intValue();
                dict.add(num);
                for (int f : factors) heap.offer(num * f);
            }
        }
    }


}
