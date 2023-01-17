package q18;

import java.util.HashMap;
import java.util.Map;

public class L1814_CountNicePairs {
    final static int MOD = (int) (1e9 + 7);

    /**
     * 方法一：暴力枚举双循环 （超时）
     * TC: O(n^2×logC) 其中 n 为数组 nums 的长度，C 为数组 nums 中的数字范围。其中 O(logC) 为反转数位的时间复杂度。
     * SC: O(1)
     */
    public int countNicePairs_1(int[] nums) {
        long total = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])) total++;
            }
        }
        return (int) (total % MOD);
    }
    /**
     * 方法二：哈希表实时累加法
     * TC: O(n×logC) 其中 n 为数组 nums 的长度，C 为数组 nums 中的数字范围。其中 O(logC) 为反转数位的时间复杂度。
     * SC: O(n)
     */
    public int countNicePairs_2(int[] nums) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = num - rev(num);
            int count = map.getOrDefault(key, 0);
            total =  (total + count) % MOD;
            map.put(key, count + 1);
        }
        return total;
    }

    /**
     * 方法三：哈希表数学计算法
     * TC: O(n×logC) 其中 n 为数组 nums 的长度，C 为数组 nums 中的数字范围。其中 O(logC) 为反转数位的时间复杂度。
     * SC: O(n)
     */
    public int countNicePairs_3(int[] nums) {
        long total = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            int key = num - rev(num);
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }
        for (long val : map.values()) total += val * (val - 1) / 2;
        return (int)(total % MOD);
    }
ddd

    private int rev(int num) {
        int revNum = 0;
        while (num > 0) {
            revNum = (revNum * 10 + num % 10);
            num /= 10;
        }
        return revNum;
    }
}
