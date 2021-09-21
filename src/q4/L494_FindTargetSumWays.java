package q4;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 */
public class L494_FindTargetSumWays {
    /**
     * 方法二：暴力回溯
     * Time: O(2^n)
     * Space: O(n)
     * 解题关键：
     * 1.
     * 2.
     */
    int count = 0;

    public int findTargetSumWays_2(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, i + 1, sum + nums[i]);
            backtrack(nums, target, i + 1, sum - nums[i]);
        }
    }
}
