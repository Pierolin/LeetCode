package q8;

import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标
 * Ambiguous Coordinates
 * https://leetcode.cn/problems/ambiguous-coordinates/
 */
public class L816_AmbiguousCoordinates {
    /**
     * 方法一：暴力枚举
     * TC: O(n^3)
     * SC: O(n^3)
     */
    public List<String> ambiguousCoordinates(String s) {
        List<String> list = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            List<String> first = generateNumber(s.substring(0, i + 1));
            List<String> second = generateNumber(s.substring(i + 1));
            for (int j = 0; j < first.size(); j++) {
                String str1 = first.get(j);
                for (int x = 0; x < second.size(); x++) {
                    String str2 = second.get(x);
                    StringBuilder sb = new StringBuilder();
                    sb.append("(").append(str1).append(", ").append(str2).append(")");
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }

    private List<String> generateNumber(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (str.charAt(0) == '0' && i > 0) break;
            if (str.charAt(n - 1) == '0' && i < n - 1) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, i + 1));
            if (i < n - 1) sb.append(".").append(str.substring(i + 1));
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        L816_AmbiguousCoordinates ac = new L816_AmbiguousCoordinates();
        List<String> list = ac.ambiguousCoordinates("(1023)");
        String[] strings = list.toArray(new String[list.size()]);
        for (String str : strings) System.out.println(str);
    }

}
