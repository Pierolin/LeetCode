package q23;

import java.util.HashSet;
import java.util.Set;

public class L2309_GreatestLetter {
    /**
     * 方法一：数组哈希
     * TC: O(n)
     * SC: O(1)
     */
    public String greatestLetter_1(String s) {
        boolean[] arr = new boolean[58];
        for (char c : s.toCharArray()) arr[c - 'A'] = true;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] && arr[i + 32]) return String.valueOf((char)(i + 'A'));
        }
        return "";
    }

    /**
     * 方法一：Set 哈希
     * TC: O(n)
     * SC: O(1)
     */
    public String greatestLetter_2(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        for (int i = 25; i >= 0; i--) {
            char upper = (char) (i + 'A');
            char lower = (char) (i + 'a');
            if (set.contains(upper) && set.contains(lower)) return String.valueOf(upper);
        }
        return "";
    }

    /**
     * 方法一：位运算
     * TC: O(n)
     * SC: O(1)
     */
    public String greatestLetter_3(String s) {
        int lowerMask = 0;
        int upperMask = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'A';
            if ( i < 26) {
                upperMask |= (1 << i);
            } else {
                lowerMask |= (1 << (c - 'a'));
            }
        }
        int mask = (lowerMask & upperMask);
        /*
        for (int i = 25; i >= 0; i--) {
            if (((mask >> i) & 1) == 1) return String.valueOf((char)(i + 'A'));
        }
        return "";
        */
        return mask > 0 ? String.valueOf((char) (31 - Integer.numberOfLeadingZeros(mask) + 'A')) : "";

    }
}
