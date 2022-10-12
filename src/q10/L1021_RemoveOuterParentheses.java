package q10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1021. 删除最外层的括号
 * Remove Outermost Parentheses
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class L1021_RemoveOuterParentheses {
    /**
     * 方法三：栈
     * TC: O(n)
     * SC: O(n)
     */
    public String removeOuterParentheses_3(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') stack.pop();
            if (!stack.isEmpty()) sb.append(c);
            if (c == '(') stack.push(c);
        }
        return sb.toString();
    }

    /**
     * 方法二：计数法
     * TC: O(n)
     * SC: O(n)
     */
    public String removeOuterParentheses_2(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') count--;
            if (count > 0) sb.append(c);
            if (c == '(') count++;
        }
        return sb.toString();
    }

    /**
     * 方法一：计数法
     * TC: O(n)
     * SC: O(n)
     */
    public String removeOuterParentheses_1(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                sb.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }

        return sb.toString();
    }
}
