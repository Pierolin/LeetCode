package q23;

/**
 * 2399. 检查相同字母间的距离
 * Check Distances Between Same Letters
 * https://leetcode.cn/problems/check-distances-between-same-letters
 */
public class L2399_CheckDistances {
    /**
     * 方法一：数组哈希
     * TC: O(n)
     * SC: O(1)
     */
    public boolean checkDistances(String s, int[] distance) {
        char[] chars = s.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < chars.length; i++) {
            int x = chars[i] -'a';
            if (hash[x] > 0 && i - hash[x] != distance[x]) return false;
            hash[x] = i + 1;
        }
        return true;
    }
}
