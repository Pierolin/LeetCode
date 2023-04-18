package q23;

/**
 * 2367. 算术三元组的数目
 * Number of Arithmetic Triplets
 * https://leetcode.cn/problems/number-of-arithmetic-triplets
 */
public class L2367_ArithmeticTriplets {
    /**
     * 方法一：数组哈希 + 一次循环
     * TC: O(n)
     * SC: O(n)
     */
    public int arithmeticTriplets_1(int[] nums, int diff) {
        int count = 0;
        int[] hash = new int[201];
        for (int num : nums) {
            hash[num] = 1;
            if (num >= 2 * diff) count += (hash[num - diff] + hash[num - diff * 2]) / 2;
        }
        return count;
    }

    /**
     * 方法三：三指针
     * TC: O(n)
     * SC: O(1)
     */
    public int arithmeticTriplets_2(int[] nums, int diff) {
        int i = 0;
        int count = 0;
        for (int k = 2; k < nums.length; k++) {
            int num = nums[k];
            while (nums[i] + 2 * diff < num) i++;
            if (nums[i] + 2 * diff > num) continue;
            int j = i + 1;
            while (nums[j] + diff < num) j++;
            if (nums[j] + diff == num) count++;
        }
        return count;
    }
}
