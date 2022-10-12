package q6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 678. 有效的括号字符串
 * Valid Parenthesis String
 * https://leetcode.cn/problems/valid-parenthesis-string/
 */
public class L678_CheckValidString {
    /**
     * 方法二：贪心法 (通过计算左括号未匹配的最小值和最大值)
     * TC: O(n)
     * SC: O(1)
     */
    public boolean checkValidString_3(String s) {
        int n = s.length();
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) return false;
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }

        return minCount == 0;
    }

    /**
     * 方法二：贪心法 (通过计算左右括号实时匹配)
     * TC: O(n)
     * SC: O(1)
     */
    public boolean checkValidString_2(String s) {
        int n = s.length();
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') {
                leftCount++;
            } else {
                leftCount--;
                if (leftCount < 0) return false;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') {
                rightCount++;
            } else {
                rightCount--;
                if (rightCount < 0) return false;
            }
        }

        return true;
    }

    /**
     * 方法一：栈
     * TC: O(n)
     * SC: O(n)
     */
    public boolean checkValidString_1(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                leftStack.push(i);
            } else if (chars[i] == '*') {
                starStack.push(i);
            } else {
                if (leftStack.isEmpty()) {
                    if (starStack.isEmpty()) return false;
                    starStack.pop();
                } else {
                    leftStack.pop();
                }
            }
        }

        while (!leftStack.isEmpty()) {
            if (starStack.isEmpty()) return false;
            if (leftStack.pop() > starStack.pop()) return false;
        }

        return true;
    }
}
