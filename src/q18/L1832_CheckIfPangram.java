package q18;

import java.util.HashSet;
import java.util.Set;

public class L1832_CheckIfPangram {
    /**
     * 方法一：数组哈希
     * TC: O(n)
     * SC: O(C) C 为 26
     */
    public boolean checkIfPangram_1(String sentence) {
        boolean[] arr = new boolean[26];
        for (char c : sentence.toCharArray()) arr[c - 'a'] = true;
        for (boolean a : arr) {
            if (!a) return false;
        }
        return true;
    }

    /**
     * 方法二：哈希
     * TC: O(n)
     * SC: O(C) C 为字母个数
     */
    public boolean checkIfPangram_2(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) set.add(c);
        return set.size() == 26;
    }

    /**
     * 方法三：位运算
     * TC: O(n)
     * SC: O(1)
     */
    public boolean checkIfPangram_3(String sentence) {
        int mask = 0;
        for (char c : sentence.toCharArray()) mask |= (1 << (c - 'a'));
        return mask == (1 << 26) - 1;
    }
}
