package q8;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L857_MincostToHireWorkers {
    /**
     * 方法一：贪心 + 优先队列（堆）
     * TC: O(nlogn)
     * SC: O(n)
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double minCost = Double.MAX_VALUE;
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) (wage[i]) / quality[i];
            workers[i][1] = (double) quality[i];
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double sumQuality = 0.0;
        for (double[] worker : workers) {
            sumQuality += worker[1];
            heap.offer(worker[1]);
            if (heap.size() == k) {
                minCost = Math.min(minCost, sumQuality * worker[0]);
                sumQuality -= heap.poll();
            }
        }
        return minCost;
    }
}

