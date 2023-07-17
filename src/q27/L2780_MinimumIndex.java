package q27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2780. Minimum Index of a Valid Split
 * 合法分割的最小下标
 */
public class L2780_MinimumIndex {

    /**
     * 方法一：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public int minimumIndex(List<Integer> nums) {
        int m = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        int domNum = 0;
        int domFreq = 0;
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            if (freq * 2 > m) {
                domNum = num;
                domFreq = freq;
            }
            map.put(num, freq);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (nums.get(i) != domNum) continue;
            count++;
            if (count * 2 > i + 1 && (domFreq - count) * 2 > m - 1 - i) return i;
        }
        return -1;
    }
}
