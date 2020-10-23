import java.util.*;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class L15_ThreeSum {
    /**
     * 方法一：双指针 + 人工判重
     * TC: O(n^2)
     * SC: O(n)
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null && nums.length < 2) return list;
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] < 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 判重
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                // 判重，如果左指针与上一个数相等，直接跳到下一个。
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                // 判重，如果右指针与上一个数相等，直接跳到下一个。
                if (right < length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }

    /**
     * 方法二：双指针 + Hash 自动判重
     * TC: O(n^2)
     * SC: O(n)
     */
    public List<List<Integer>> threeSum_2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        Set<List<Integer>> list = new LinkedHashSet<>();
        for (int i = 0; i < length - 2; i++) {
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(list);
    }

    /**
     * 方法三：暴力解法
     * TC: O(n^3)
     * SC: O(n)
     */
    public List<List<Integer>> threeSum_3(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        Set<List<Integer>> list = new LinkedHashSet<>();
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int n = j + 1; n < length; n++) {
                    if (nums[i] + nums[j] + nums[n] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[n]));
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }
}
