package q8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 856. 括号的分数
 * Score of Parentheses
 * https://leetcode.cn/problems/score-of-parentheses/
 */
public class L856_ScoreOfParentheses {
    /**
     * 方法三： 递归分治
     * TC: O(n^2)
     * SC: O(n^2)
     * 题解： https://leetcode.cn/problems/score-of-parentheses/solution/by-ac_oier-0mhz/
     */
    public int scoreOfParentheses_3(String s) {
        int n = s.length();
        if (n == 2) return 1;

        int balance = 0;
        int i = 0;
        while (true) {
            balance += s.charAt(i++) == '(' ? 1 : -1;
            if (balance == 0) break;
        }

        if (i == n) {
            return scoreOfParentheses_3(s.substring(1, n - 1)) * 2;
        } else {
            return scoreOfParentheses_3(s.substring(0, i)) + scoreOfParentheses_3(s.substring(i));
        }
    }

    /**
     * 方法二： 栈
     * TC: O(n)
     * SC: O(n)
     * 题解： https://leetcode.cn/problems/score-of-parentheses/solution/by-ac_oier-0mhz/
     */
    public int scoreOfParentheses_2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int prev = stack.pop();
                int score = ((prev == 0) ? 1 : prev * 2);
                stack.push(stack.isEmpty() ? score : stack.pop() + score);
            }
        }
        return stack.peek();
    }

    /**
     * 方法一： 记数法
     * TC: O(n)
     * SC: O(1)
     * 题解： https://leetcode.cn/problems/score-of-parentheses/solution/by-lcbin-b9st/
     */
    public int scoreOfParentheses_1(String s) {
        int score = 0;
        int deep = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deep++;
            } else {
                deep--;
                if (s.charAt(i - 1) == '(') {
                    score += 1 << deep;
                }
            }
        }
        return score;
    }
}
