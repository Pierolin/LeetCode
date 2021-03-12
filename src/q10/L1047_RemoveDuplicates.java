package q10;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class L1047_RemoveDuplicates {
    /**
     * 方法一：
     *
     */
    public String removeDuplicates_1(String S) {
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for (char c : S.toCharArray()) {
            if (top > - 1 && sb.charAt(top) == c) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(c);
                top++;
            }
        }
        return sb.toString();
    }

    /**
     * 方法二
     *
     */
    public String removeDuplicates_2(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (stack.isEmpty() || chars[i] != stack.peek()) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
