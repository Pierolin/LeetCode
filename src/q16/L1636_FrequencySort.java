package q16;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 * Sort Array by Increasing Frequency
 * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 */
public class L1636_FrequencySort {

    /**
     * 方法一：哈希表自定义排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int[] frequencySort_1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }

        Collections.sort(list, (a, b) -> {
            int countA = map.get(a);
            int countB = map.get(b);
            return countA == countB ? b - a : countA - countB;
        });

        for (int i = 0; i < list.size(); i++) nums[i] = list.get(i);

        return nums;
    }

    /**
     * 方法二：哈希表自定义排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int[] frequencySort_2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int countA = map.get(a);
            int countB = map.get(b);
            return countA == countB ? b - a : countA - countB;
        }).mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 方法三：數組統計
     * TC: O(1)
     * SC: O(1)
     */
    public int[] frequencySort_3(int[] nums) {
        int[] counts = new int[201];
        for (int num : nums) counts[num + 100]++;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 200; i >= 0; i--) {
            int c = counts[i];
            if (c == 0) continue;
            if (!map.containsKey(c)) map.put(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }

        int j = 0;
        for (int i = 1; i <= 101; i++) {
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                for (int n = 0; n < list.size(); n++) {
                    int num = list.get(n);
                    while (counts[num]-- > 0) nums[j++] = num - 100;
                }
            }
        }
        return nums;
    }


}
