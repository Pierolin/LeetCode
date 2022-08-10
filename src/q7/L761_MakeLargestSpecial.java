package q7;

import java.util.*;

/**
 * 761. 特殊的二进制序列
 * Special Binary String
 * https://leetcode.cn/problems/special-binary-string/
 */
public class L761_MakeLargestSpecial {
    public String makeLargestSpecial(String s) {
        if (s == null) return null;
        if (s.length() <= 2) return s;

        List<String> specials = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    specials.add("1" + makeLargestSpecial(s.substring(start + 1, i)) + "0");
                    start = i + 1;
                }
            }
        }

        specials.sort((a, b) -> b.compareTo(a));
        //specials.sort(Comparator.reverseOrder());
        //Collections.sort(specials, (a, b) -> b.compareTo(a));

        return String.join("", specials);
    }
}
