package q2;

import java.util.*;

/**
 * 290. 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class L290_WordPattern {
    /**
     * 方法一：使用哈希表 put 返回值的特性
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1. 把 pattern 和 word 都作为 key，索引 i 作为 value 加进 map 里;
     * 2. 比较 put 进去的 pattern 和  word 所返回的 i 值是否相等，当 key 不存在 put 方法返回 null, 如果已存在，则返回上一次 put 进去的值。
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map index = new HashMap();
        for (int i = 0; i < words.length; ++i) {
            if (!Objects.equals(index.put(pattern.charAt(i), i), index.put(words[i], i))) return false;
        }
        /*
        // 另一种写法：
         for (Integer i = 0; i < words.length; ++i) { // 注意这里为何使用 Integer 而不是 int, 这是由于 map 的值只能是对象 Integer, int 会自动转为 Integer.
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) return false;
         }
        */
        return true;
    }

    /**
     * 方法二：使用数组 + 哈希表
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1. pattern 为小写 26 个字母，把所有单词拆分存在一个大小为 26 的数组里，数组索引为 pattern 字母 chars[i] - 'a';
     * 2. 使用 set 存储判断值是否已存在，如果范式字母不存在而单词存在，则说明不匹配。
     */
    public boolean wordPattern_2(String pattern, String s) {
        if (pattern == null || s == "") return false;

        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        if (chars.length != words.length) return false;

        String[] matches = new String[26];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            int j = chars[i] - 'a';
            if (matches[j] == null) {
                if (set.contains(words[i])) return false;
                matches[j] = words[i];
                set.add(words[i]);
            } else {
                if (!matches[j].equals(words[i])) return false;
            }
        }

        return true;
    }

    /**
     * 方法三：哈希表
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     * 1. 使用 HashMap 的 containsKey 和 containsValue 可分别判断范式和单词是否存在
     */
    public boolean wordPattern_3(String pattern, String s) {
        if (pattern == null || s == "") return false;

        char[] keys = pattern.toCharArray();
        String[] words = s.split(" ");
        if (keys.length != words.length) return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(keys[i])) {
                if (map.containsValue(words[i])) return false;
                map.put(keys[i], words[i]);
            } else {
                if (!map.get(keys[i]).equals(words[i])) return false;
            }
        }

        return true;
    }
}
