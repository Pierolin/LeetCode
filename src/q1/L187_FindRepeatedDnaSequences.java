package q1;

import java.util.*;

public class L187_FindRepeatedDnaSequences {
    /**
     * 方法二：滑动窗口 + 哈希表
     * TC: O(n * m) m 为要找的字符串的长度
     * SC: O(n)
     */
    public List<String> findRepeatedDnaSequences_2(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            int count = map.getOrDefault(sub, 0);
            if (count == 1) list.add(sub);
            map.put(sub, count + 1);
        }
        return list;
    }

    /**
     * 方法一：滑动窗口 + 哈希表
     * TC: O(n * m) m 为要找的字符串的长度
     * SC: O(n)
     */
    public List<String> findRepeatedDnaSequences_1(String s) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                if (!list.contains(sub)) list.add(sub);
            } else {
                set.add(sub);
            }
        }
        return list;
    }


}
