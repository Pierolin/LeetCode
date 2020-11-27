import java.util.HashMap;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class L1_TwoSum {
    /**
     * 方法一：哈希法
     * Time: O(n)
     * Space: O(1)
     * 解题思路
     * 1. 使用数组元素的值作为哈希表的 key, 哈希值为索引;
     */
    public int[] twoSum_1(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    /**
     * 方法二：双循环
     * Time: O(n^2)
     * Space: O(1)
     */
    public int[] twoSum_2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
