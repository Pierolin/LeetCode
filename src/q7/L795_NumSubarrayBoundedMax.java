package q7;

/**
 * 795. 区间子数组个数
 * 795. Number of Subarrays with Bounded Maximum
 * https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/description/
 */
public class L795_NumSubarrayBoundedMax {

    /**
     * 方法二：计数法
     * TC: O(n)
     * SC: O(1)
     */
    public int numSubarrayBoundedMax_2(int[] nums, int left, int right) {
        return countLessEqualThan(nums, right) - countLessEqualThan(nums, left - 1);
    }

    private int countLessEqualThan(int[] nums, int target) {
        int count = 0;
        int curr = 0;
        for (int num : nums) {
            curr = num <= target ? curr + 1 : 0;
            count += curr;
        }
        return count;
    }

    /**
     * 方法一：模拟 (一次遍历）
     * TC: O(n)
     * SC: O(1)
     */
    public int numSubarrayBoundedMax_1(int[] nums, int left, int right) {
        int sum = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            /*
            if (num >= left && num <= right) {
                end = i;
                sum += end - start;
            } else if (num > right) {
                start = i;
                end = i;
            } else if (num < left) {
                if (end > -1) sum += end - start;
            }
            */
            // 如下为简洁写法，原理一样
            if (num > right) end = i;
            if (num >= left) start = i;
            sum += start - end;
        }
        return sum;
    }
}
