import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class L242_IsAnagram {
    /**
     * 方法一：哈希表
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1. 分别使用数组对两个字符串的字母进行计数
     * 2. 比较这两个数组，完全一样就是异位词
     */
    public boolean isAnagram_1(String s, String t) {
        int[] arr = new int[26];

        for (int c : s.toCharArray()) arr[c - 'a']++;
        for (int c : t.toCharArray()) arr[c - 'a']--;

        for (int i : arr) {
            if (i != 0) return false;
        }

        return true;
    }

    /**
     * 方法二：排序法
     * Time: O(nlogn)
     * Space: O(n)
     * 解题思路：
     * 1. 分别转化为字符数组并排序；
     * 2. 比较两个数组
     */
    public boolean isAnagram_2(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS, charT);
    }
}
