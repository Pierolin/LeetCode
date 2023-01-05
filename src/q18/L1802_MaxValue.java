package q18;

/**
 * 1802. 有界数组中指定下标处的最大值
 * Maximum Value at a Given Index in a Bounded Array
 * https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/
 */
public class L1802_MaxValue {

    /**
     * 方法一：贪心 + 二分查找
     * TC: O(lg(maxSum))
     * SC: O(1)
     */
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long sum = calSum(mid, index, n);
            if (sum == maxSum) return mid;
            if (sum < maxSum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    private long calSum(int x, int i, int n) {
        long sum = 0;
        long leftSum = 0;
        long rightSum = 0;
        // 左侧求和
        if (i >= x) {
            int first = 1;
            int last = x - 1;
            int count = x - 1;
            leftSum += (long) (first + last) * count / 2;
            leftSum += i - x + 1;
        } else {
            int first = x - i;
            int last = x - 1;
            int count = i;
            leftSum += (long) (first + last) * count / 2;
        }
        // 右侧求和
        if (n - i - 1 >= x) {
            int first = 1;
            int last = x - 1;
            int count = x - 1;
            rightSum += (long) (first + last) * count / 2;
            rightSum += n - i - x;
        } else {
            int first = x - ((n - 1) - i);
            int last = x - 1;
            int count = (n - 1) - i;
            rightSum += (long) (first + last) * count / 2;
        }
        sum = leftSum + x + rightSum;
        return sum;
    }
}
