package q2;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class L264_NthUglyNumber {
    /**
     * 方法二：动态规划
     * TC: O(n)
     * SC: O(n)
     */
    public int nthUglyNumber_2(int n) {
        int[] uglies = new int[n];
        uglies[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = uglies[i2] * 2;
            int num3 = uglies[i3] * 3;
            int num5 = uglies[i5] * 5;
            int min = Math.min(Math.min(num2, num3), num5);
            uglies[i] = min;
            if (min == num2) i2++;
            if (min == num3) i3++;
            if (min == num5) i5++;
        }
        return uglies[n - 1];
    }

    /**
     * 方法一：优先队列（最小堆）
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int nthUglyNumber_1(int n) {
        int[] uglies = {2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        Set<Long> dict = new HashSet<>();
        Long min = 0L;
        for (int i = 0; i < n; i++) {
            min = heap.poll();
            if (i == n - 1) break;
            for (int u : uglies) {
                Long num = min * u;
                if (dict.add(num)) heap.offer(num);
            }
        }
        return min.intValue();
    }
}
