package q0;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 * Valid Parentheses
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class L30_IsValid {

    /**
     * 方法一：栈
     * TC: O(n)
     * SC: O(n)
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.pop()) != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
