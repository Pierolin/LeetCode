package q23;

/**
 * 2351. 第一个出现两次的字母
 * First Letter to Appear Twice
 * https://leetcode.cn/problems/first-letter-to-appear-twice/description/
 */
public class L2351_RepeatedCharacter {

    /**
     * 方法一：哈希表
     * TC: O(n)
     * SC: O(1)
     */
    public char repeatedCharacter_1(String s) {
        boolean[] arr = new boolean[26];
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (arr[i]) return c;
            arr[i] = true;
        }
        return ' ';
    }

    /**
     * 方法二：位运算
     * TC: O(n)
     * SC: O(1)
     */
    public char repeatedCharacter_2(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            int curr = 1 << (c = 'a');
            if (((curr & mask) != 0)) return c;
            mask |= curr;
        }
        return ' ';
    }
}
