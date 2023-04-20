package q24;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. 出现最频繁的偶数元素
 * Most Frequent Even Element
 * https://leetcode.cn/problems/most-frequent-even-element
 */
public class L2404_MostFrequentEven {

    /**
     * 方法一：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public int mostFrequentEven_1(int[] nums) {
        int mostEven = -1;
        int mostFrequency = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if ((num & 1) == 1) continue;
            int frequency = map.getOrDefault(num, 0) + 1;
            map.put(num, frequency);
            if (frequency > mostFrequency) {
                mostFrequency = frequency;
                mostEven = num;
            } else if (frequency == mostFrequency && num < mostEven) {
                mostEven = num;
            }
        }
        return mostEven;
    }

    /**
     * 方法一：数组统计
     * TC: O(n)
     * SC: O(n)
     */
    public int mostFrequentEven_2(int[] nums) {
        int mostEven = -1;
        int mostFrequency = 0;
        int[] counts = new int[100001];
        for (int num : nums) {
            if ((num & 1) == 1) continue;
            counts[num]++;
        }
        for (int i = 0; i < counts.length; i = i + 2) {
            if (counts[i] > mostFrequency) {
                mostFrequency = counts[i];
                mostEven = i;
            }
        }
        return mostEven;
    }
}
