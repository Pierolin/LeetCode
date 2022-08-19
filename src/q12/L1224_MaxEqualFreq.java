package q12;

import java.util.HashMap;
import java.util.Map;

/**
 * 1224. 最大相等频率
 * Maximum Equal Frequency
 * https://leetcode.cn/problems/maximum-equal-frequency/
 */
public class L1224_MaxEqualFreq {
    /**
     * 方法一：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public int maxEqualFreq(int[] nums) {
        // 记录数字的数量
        Map<Integer, Integer> numMap = new HashMap<>();
        // 记录数字的数量的数量
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int freq = numMap.getOrDefault(num, 0);
            // 因为当前数字的数量要 +1， 所以该数字的数量的数量必将 -1，
            if (freqMap.containsKey(freq) && freqMap.get(freq) > 0) {
                freqMap.put(freq, freqMap.get(freq) - 1);
            }

            // 数字的数量 +1
            freq++;
            numMap.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
            // 数字的数量 +1 后的数量的数量 +1
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);

            // 分三种情况：
            // 1. 所有数字的数量都是 1，如 [1,2,3,4,5,6];
            // 2. 去掉一个数字后其他数字的数量相等，如 [2,2,1,1,3] 去掉一个 3;
            // 3. 去掉一个数字后包含当前数字的所有数字的数量相等，如 [2,2,1,1,3,3,3] 去掉一个3
            if (maxFreq == 1 ||
                    maxFreq * freqMap.get(maxFreq) == i ||
                    maxFreq + (maxFreq - 1) * freqMap.get(maxFreq - 1) == i + 1
            ) {
                longest = Math.max(longest, i + 1);
            }
        }
        return longest;
    }
}
