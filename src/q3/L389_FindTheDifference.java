package q3;

import java.util.HashSet;
import java.util.Set;

/**
 * 389. Find the Difference
 * 找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class L389_FindTheDifference {
    /**
     * 方法一：异或位运算法
     * Time: O(n)
     * Space: O(1)
     * 解题关键：
     * 1. 连接两个字符串;
     * 2. 遍历字符串取异或。
     */
    public char findTheDifference_1(String s, String t) {
        char diff = 0;
        for (char c : s.concat(t).toCharArray()) diff ^= c;
        return diff;
        // 可简化为如下 1 行，但执行效率不高，原因何在？
        // return (char) s.concat(t).chars().reduce(0, (a, b) -> a ^ b);
    }

    /**
     * 方法二：计数法
     * Time: O(n)
     * Space: O(1)
     * 解题关键：
     * 1. 对第 1 个字符串的字符进行计数;
     * 2. 遍历第 2 个字符串的字符，计数减 1， 若为 0，说明该字符不存在。
     */
    public char findTheDifference_2(String s, String t) {
        int[] charsCount = new int[26];
        for (char c : s.toCharArray()) charsCount[c - 'a']++;
        for (char c : t.toCharArray()) {
            int i = c - 'a';
            if (charsCount[i] == 0) return c;
            charsCount[i]--;
        }
        return ' ';
    }

    /**
     * 方法三：求差法
     * Time: O(n)
     * Space: O(1)
     * 关键思路：
     * 1. 两个字符吕对应的字符相减
     */
    public char findTheDifference_3(String s, String t) {
        /*
        int diff = t.charAt(0) - 'a';
        for (int i = 0; i < s.length(); i++) {
            diff += t.charAt(i + 1) - s.charAt(i);
        }
        return (char)(diff + 'a');
        */
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int diff = charsT[0] - 'a';
        for (int i = 0; i < charsS.length; i++) {
            diff += charsT[i + 1] - charsS[i];
        }
        return (char) (diff + 'a');
    }

    /**
     * 方法四：哈希 Set 法
     * Time: O(n)
     * Space: O(n)
     * 关键思路：
     * 1. 使用 HastSet 存储判断字符;
     * 2. 存在加入，不存在移除，最后留下来的就是多的那个字符。
     */
    public char findTheDifference_4(String s, String t) {
        Set<Character> set = new HashSet<>();
        for (char c : (s + t).toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return (char) set.toArray()[0];
    }
}
