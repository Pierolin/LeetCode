package q0;

public class L58_LengthOfLastWord {
    /**
     * 方法一：反向遍历
     * TC: O(n)
     * SC: O(1)
     * 解题思路：从右到左开始遍历
     */
    public int lengthOfLastWord_1(String s) {
        int len = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) != ' ') {
                len++;
            }
            else {
                if (len > 0) return len;
            }
        }
        return len;
    }

    /**
     * 方法二：正向遍历
     * TC: O(n)
     * SC: O(1)
     * 解题思路：从左到右开始遍历
     */
    public int lengthOfLastWord_2(String s) {
        int len = 0;
        int last = s.length() - 1;
        for (int i = 0; i < last; i++) {
            if (s.charAt(i) != ' ') {
                len++;
            } else {
                if (s.charAt(i + 1) != ' ') len = 0;
            }
        }
        if (s.charAt(last) != ' ') len++;
        return len;
    }
}
