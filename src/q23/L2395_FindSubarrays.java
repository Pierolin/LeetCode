package q23;

import java.util.HashSet;
import java.util.Set;

/**
 * 2395. 和相等的子数组
 * Find Subarrays With Equal Sum
 * https://leetcode.cn/problems/find-subarrays-with-equal-sum
 */
public class L2395_FindSubarrays {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!set.add(nums[i - 1] + nums[i])) return true;
        }
        return false;
    }

}
