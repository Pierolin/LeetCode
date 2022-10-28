package q13;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class L13_RomanToInt {
    /**
     * 方法二：哈希法
     * TC: O(n)
     * SC: O(1)
     */
    public int romanToInt_2(String s) {
        int sum = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        for (int i = 0; i < n - 1; i++) {
            int val = map.get(s.charAt(i));
            if (val < map.get(s.charAt(i + 1))) val = -val;
            sum += val;
        }
        sum += map.get(s.charAt(n - 1));
        return sum;
    }

    /**
     * 方法一：哈希法
     * TC: O(n)
     * SC: O(1)
     */
    public int romanToInt_1(String s) {
        int sum = 0;
        int n = s.length();
        Map<String, Integer> map = new HashMap<>(){{
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};

        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                String symbol = s.substring(i, i + 2);
                if(map.containsKey(symbol)) {
                    sum += map.get(symbol);
                    i++;
                    continue;
                }
            }
            sum += map.get(s.substring(i, i + 1));
        }
        return sum;
    }
}
