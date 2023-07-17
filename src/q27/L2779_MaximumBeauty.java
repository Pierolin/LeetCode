package q27;

import java.util.Arrays;

/**
 * 2779. Maximum Beauty of an Array After Applying Operation
 * 数组的最大美丽值
 */
public class L2779_MaximumBeauty {

    /**
     * 方法一：排序 + 滑动窗口
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (nums[left] + k < nums[right] - k) left++;
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
