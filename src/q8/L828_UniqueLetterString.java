package q8;

import java.util.*;

/**
 * 828. 统计子串中的唯一字符
 * Count Unique Characters of All Substrings of a Given String
 * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 */
public class L828_UniqueLetterString {
    /**
     * 方法四：数学 + 数组
     * TC: O(n)
     * SC: O(n)
     */
    public int uniqueLetterString_4(String s) {
        int len = s.length();
        int total = 0;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        for (int n = 0; n < len; n++) {
            int i = s.charAt(n) - 'A';
            if (arr2[i] > -1) {
                total += (arr2[i] - arr1[i]) * (n - arr2[i]);
            }
            arr1[i] = arr2[i];
            arr2[i] = n;
        }

        for (int i = 0; i < 26; i++) {
            if (arr2[i] > -1) {
                total += (arr2[i] - arr1[i]) * (len - arr2[i]);
            }
        }
        return total;
    }

    /**
     * 方法三：数学 + 哈希
     * TC: O(n)
     * SC: O(n)
     */
    public int uniqueLetterString_3(String s) {
        int len = s.length();
        int total = 0;
        Map<Character, List<Integer>> mapIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char letter = s.charAt(i);
            if (!mapIndex.containsKey(letter)) {
                mapIndex.put(letter, new ArrayList());
            }
            mapIndex.get(letter).add(i);
        }

        for (Map.Entry<Character, List<Integer>> entry : mapIndex.entrySet()) {
            List<Integer> listIndex = entry.getValue();
            int size = listIndex.size();
            for (int i = 0; i < size; i++) {
                int index = listIndex.get(i);
                int prev = (i == 0 ? -1 : listIndex.get(i - 1));
                int next = (i == size - 1 ? len : listIndex.get(i + 1));
                total += (index - prev) * (next - index);
            }
        }
        return total;
    }

    /**
     * 方法二：暴力枚举改进版(超时)
     * TC:
     * SC:
     */
    public int uniqueLetterString_2(String s) {
        int len = s.length();
        int total = 0;
        for (int i = 0; i < len; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int preCount = 0;
            int subTotal = 0;
            for (int j = i; j < len; j++) {
                subTotal += preCount;
                char key = s.charAt(j);
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                    subTotal++;
                    preCount++;
                } else {
                    int count = map.get(key);
                    map.put(key, count + 1);
                    if (count == 1) {
                        subTotal--;
                        preCount--;
                    }
                }
            }
            total += subTotal;
        }
        return total;
    }

    /**
     * 方法一：暴力枚举(超时)
     * TC:
     * SC:
     */
    public int uniqueLetterString_1(String s) {
        int len = s.length();
        int total = len;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 2; j <= len; j++) {
                total += countUniqueChars(s.substring(i, j));
            }
        }
        return total;
    }

    private int countUniqueChars(String t) {
        int count = 0;
        int[] chars = new int[26];
        for (char c : t.toCharArray()) {
            chars[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] == 1) count++;
        }
        return count;
    }
}
