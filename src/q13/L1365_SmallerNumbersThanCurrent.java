package q13;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1365. 有多少小于当前数字的数字
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class L1365_SmallerNumbersThanCurrent {

    /**
     * 方法一：计数法
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 题目提示最大数不会超过 100，故可设置一个长度为 101 的数组计数器 counter 用来记录这些 <= 100 的元素分别出现的次数;
     * 2. 单个元素的个数统计完后，在同一个数组 counter 上进行小于当前数的元素的个数;
     * 3. 小于某数(x = nums[i])的个数可以通过 counter[x-1] 取得
     */
    public int[] smallerNumbersThanCurrent_1(int[] nums) {
        // 题目提示：0 <= nums[i] <= 100
        int[] counter = new int[101];

        // 统计每个数字出现的出数
        for (int num : nums) counter[num]++;

        // 计算小于 i 的数字有多少
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        // 组织返回结果
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            result[i] = counter[nums[i] - 1];
        }
        return result;
    }

    /**
     * 方法二：API 排序 + Hash 字典
     * TC: O(nlogn) 为 Arrays.sort 的时间复杂度
     * SC: O(n)
     * 解题思路：
     * 1. 使用 API 的 Arrays.sort 进行排序;
     * 2. 如果当前数与前一数没有重复，小于当前数的数目即为当前数的下标;
     * 3. 使用 HashMap 记录小于某个数的数目;
     */
    public int[] smallerNumbersThanCurrent_2(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedNums.length; i++) {
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) continue;
            map.put(sortedNums[i], i);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }

    /**
     * 方法一：暴力解法 + Hash 表
     * TC: O(n^2)
     * SC: O(n)
     * 解题思路：
     * 1. 暴力双重循环;
     * 2. 用 Hash 表来存储计算过的数，以节省时间。
     */
    public int[] smallerNumbersThanCurrent_3(int[] nums) {
        int[] result = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                result[i] = calculate(i, nums);
                map.put(nums[i], result[i]);
            } else {
                result[i] = map.get(nums[i]);
            }

        }
        return result;
    }

    private int calculate(int i, int[] nums) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j == i) continue;
            if (nums[j] < nums[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 2, 1, 3};
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        System.out.println(Arrays.toString(nums));
    }
}
