package q20;

import java.util.*;

/**
 * 2032. 至少在两个数组中出现的值
 * Two Out of Three
 * https://leetcode.cn/problems/two-out-of-three/description/
 */
public class L2032_TwoOutOfThree {

    /**
     * 方法一：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public List<Integer> twoOutOfThree_1(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        handle(map, nums1);
        handle(map, nums2);
        handle(map, nums3);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) list.add(entry.getKey());
        }
        return list;
    }

    private void handle(Map<Integer, Integer> map, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : set) map.put(num, map.getOrDefault(num, 0) + 1);
    }

    /**
     * 方法二：数组统计
     * TC: O(n)
     * SC: O(n)
     */
    public List<Integer> twoOutOfThree_2(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        int[] arr1 = handle(nums1);
        int[] arr2 = handle(nums2);
        int[] arr3 = handle(nums3);
        for (int i = 1; i < 101; i++) {
            if (arr1[i] + arr2[i] + arr3[i] > 1) list.add(i);
        }
        return list;

    }

    private int[] handle(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) arr[num] = 1;
        return arr;
    }

    /**
     * 方法三：位运算
     * TC: O(n)
     * SC: O(n)
     */
    public List<Integer> towOutOfThree_3(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[101];
        for (int n : nums1) arr[n] |= 1;
        for (int n : nums2) arr[n] |= 2;
        for (int n : nums3) arr[n] |= 4;
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            if ((x & (x - 1)) != 0) list.add(i);
        }
        return list;
    }
}
