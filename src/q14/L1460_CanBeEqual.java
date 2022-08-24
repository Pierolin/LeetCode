package q14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * Make Two Arrays Equal by Reversing Sub-arrays
 * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class L1460_CanBeEqual {
    /**
     * 方法一：排序比较法
     * TC： O(nlogn)
     * SC: O(nlogn)
     */
    public boolean canBeEqual_1(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    /**
     * 方法二：哈希表法
     * TC: O(n)
     * SC: O(n)
     */
    public boolean canBeEqual_2(int[] target, int[] arr) {
        Map<Integer, Integer> hashTarget = new HashMap<>();
        Map<Integer, Integer> hashArr = new HashMap<>();
        for (int num : target) hashTarget.put(num, hashTarget.getOrDefault(num, 0) + 1);
        for (int num : arr) hashArr.put(num, hashArr.getOrDefault(num, 0) + 1);
        for (int key : hashTarget.keySet()) {
            if (!hashArr.containsKey(key) || hashTarget.get(key) != hashArr.get(key)) return false;
        }
        return true;
    }

    /**
     * 方法三：区间词频统计
     * TC: O(n)
     * SC: O(n)
     */
    public boolean canBeEqual_3(int[] target, int[] arr) {
        int[] counts = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            counts[target[i]]++;
            counts[arr[i]]--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

    /**
     * 方法四：区间词频统计 (更巧妙的写法）
     * TC: O(n)
     * SC: O(n)
     */
    public boolean canBeEqual_4(int[] target, int[] arr) {
        int total = 0;
        int[] counts = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            if (++counts[target[i]] == 1) total++;
            if (--counts[arr[i]] == 0) total--;
        }
        return total == 0;
    }
}
