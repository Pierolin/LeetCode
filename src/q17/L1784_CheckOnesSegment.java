package q17;

import java.util.regex.Pattern;

/**
 * 1784. 检查二进制字符串字段
 * Check if Binary String Has at Most One Segment of Ones
 * https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 */
public class L1784_CheckOnesSegment {
    /**
     * 方法三：模拟
     * TC: O(n)
     * SC: O(1)
     */
    public boolean checkOnesSegment_3 (String s) {
        boolean hasZero = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                hasZero = true;
            } else {
                if (hasZero) return false;
            }
        }
        return true;
    }
    /**
     * 方法二：正则表达式
     * TC: O(n)
     * SC: O(1)
     */
    public boolean checkOnesSegment_2 (String s) {
        return Pattern.compile("^1*0*").matcher(s).find();
    }

    /**
     * 方法一：脑筋急转弯
     * TC: O(n)
     * SC: O(1)
     */
    public boolean checkOnesSegment_1 (String s) {
        return !s.contains("01");
    }
}
