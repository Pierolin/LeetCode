package q24;

/**
 * 2460. 对数组执行操作
 * Apply Operations to an Array
 * https://leetcode.cn/problems/apply-operations-to-an-array
 */
public class L2460_ApplyOperations {
    /**
     * 方法一：新建数组
     * TC：O(n)
     * SC: O(n)
     */
    public int[] applyOperations_1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int j = -1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num > 0) {
                ans[++j] = nums[i];
                if (i < n - 1 && nums[i] == nums[i + 1]) {
                    ans[j] = ans[j] * 2;
                    i++;
                }
            }
        }
        return ans;
    }

    /**
     * 方法二: 直接模拟
     * TC：O(n)
     * SC: O(1)
     */
    public int[] applyOperations_2(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
