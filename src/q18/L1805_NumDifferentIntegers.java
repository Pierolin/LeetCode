package q18;

import java.util.HashSet;
import java.util.Set;

public class L1805_NumDifferentIntegers {
    /**
     * 方法三：API + 正则表达式
     * TC: O(n)
     * SC: O(n)
     */
    public int numDifferentIntegers_3(String word) {
        Set<String> set = new HashSet<>();
        for (String num : word.split("[a-z]+")) {
            if (num.length() > 0) set.add(num.replaceAll("^0+", ""));
        }
        return set.size();
    }

    /**
     * 方法二：哈希表 + 双指针
     * TC: O(n)
     * SC: O(n)
     */
    public int numDifferentIntegers_2(String word) {
        Set<String> set = new HashSet<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < n - 1 && Character.isDigit(word.charAt(j + 1))) j++;
                while (i < j && word.charAt(i) == '0') i++;
                set.add(word.substring(i, j + 1));
                i = j;
            }
        }
        return set.size();
    }

    /**
     * 方法一：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public int numDifferentIntegers_1(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            String num = sb.toString();
            if (Character.isDigit(c)) {
                if (num.equals("") && c == '0' && i < n - 1 && Character.isDigit(word.charAt(i + 1))) continue;
                sb.append(c);
            } else {
                if (!num.equals("")) {
                    set.add(num);
                    sb = new StringBuilder();
                }
            }
        }
        if (!sb.toString().equals("")) set.add(sb.toString());
        return set.size();
    }


}
