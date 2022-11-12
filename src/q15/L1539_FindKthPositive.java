package q15;

/**
 * 1539. 第 k 个缺失的正整数
 * Kth Missing Positive Number
 * https://leetcode.cn/problems/kth-missing-positive-number/description/
 */
public class L1539_FindKthPositive {
    /**
     * 方法二：二分查找
     * TC: O(logn)
     * SC: O(1)
     */
    public int findKthPositive_2(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int diff = arr[mid] - (mid + 1);
            if (diff < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
        //return arr[left - 1] + (k - (arr[left - 1] - ((left - 1) + 1)));
    }
    /**
     * 方法一：模拟枚举
     * TC: O(n)
     * SC: O(1)
     */
    public int findKthPositive_1(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr = (i == 0 ? 1 : arr[i - 1] + 1);
            int diff = arr[i] - curr;
            if (diff >= k) return curr + k - 1;
            k -= diff;
        }
        return arr[n - 1] + k;
    }
}
