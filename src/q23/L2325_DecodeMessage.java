package q23;

import java.util.HashMap;
import java.util.Map;

/**
 * 2325. 解密消息
 * Decode the Message
 * https://leetcode.cn/problems/decode-the-message/
 */
public class L2325_DecodeMessage {
    /**
     * 方法一：哈希表
     * TC: O(m+n)
     * SC: O(1)
     */
    public String ecodeMessage_1(String key, String message) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        char i = 'a';
        for (char c : key.toCharArray()) if (!map.containsKey(c)) map.put(c, i++);
        for (char c : message.toCharArray()) sb.append(map.get(c));
        return sb.toString();
    }

    /**
     * 方法二：数组哈希
     * TC: O(m+n)
     * SC: O(1)
     */
    public String decodeMessage_2(String key, String message) {
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[26];
        char i = 'a';
        for (char c : key.toCharArray()) {
            int j = c - 'a';
            if (c == ' ' || arr[j] > 0) continue;
            arr[j] = i++;
        }
        for (char c : message.toCharArray()) sb.append(c == ' ' ? ' ' : arr[c - 'a']);
        return sb.toString();
    }
}
