package q0;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class L3_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                max = Integer.max(max, i - start);
                start = map.get(c) + 1;
            }
            map.put(c, i);
        }
        max = Integer.max(max, len - start);

        return max;
    }
}
