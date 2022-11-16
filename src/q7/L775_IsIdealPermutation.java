package q7;

public class L775_IsIdealPermutation {
    /**
     * 方法一：前缀最大值
     * TC: O(n)
     * SC: O(1)
     */
    public boolean isIdealPermutation_2(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (max > nums[i]) return false;
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }

    /**
     * 方法一：偏移量
     * TC: O(n)
     * SC: O(1)
     */
    public boolean isIdealPermutation_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - 1) > 1) return false;
        }
        return true;
    }
}
