import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 */
public class L18_FourSum {
    /**
     * 双指针法
     * Time: O(n^3)
     * Space: O(n)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) return list;

        Arrays.sort(nums);

        for (int f = 0; f < len - 3; f++) {
            if (f > 0 && nums[f] == nums[f - 1]) continue;
            for (int s = f + 1; s < len - 2; s++) {
                if (s > f + 1 && nums[s] == nums[s - 1]) continue;
                int l = s + 1;
                int r = len - 1;
                while (l < r) {
                    if (l > s + 1 && nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                    if (r < len - 1 && nums[r] == nums[r + 1]) {
                        r--;
                        continue;
                    }
                    int sum = nums[f] + nums[s] + nums[l] + nums[r];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[f], nums[s], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return list;
    }
}
