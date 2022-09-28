package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class I0102_CheckPermutation {

    /**
     * 方法三：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public boolean checkPermutation_3(String s1, String s2) {
        int[] counts = new int[128];
        for (char c : s1.toCharArray()) counts[c]++;
        for (char c : s2.toCharArray()) counts[c]--;
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

    /**
     * 方法二：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public boolean checkPermutation_2(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : s2.toCharArray()) map.put(c, map.getOrDefault(c, 0) - 1);
        for (char c : map.keySet()) {
            if (map.get(c) != 0) return false;
        }
        return true;
    }


    /**
     * 方法二：排序法
     * TC: O(nlogn)
     * SC: O(n)
     */
    public boolean checkPermutation_1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
