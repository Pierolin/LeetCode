import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class L454_FourSumCount {
    /**
     * 哈希表
     * Time: O(n^2)
     * Space: O(n^2)
     * 解题思路：
     * 1.
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int key = a + b;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int key = (c + d) * -1;
                if (map.containsKey(key)) count += map.get(key);
            }
        }
        return count;
    }
}
