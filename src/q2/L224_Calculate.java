package q2;

import java.util.Stack;

public class L224_Calculate {
    public int calculate_1(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                num = num * 10 + sign * (c - '0');
            } else {
                result += num;
                num = 0;
                if (c == ' ') {
                    continue;
                } else if (c == '+') {
                    sign = stack.peek();
                } else if (c == '-') {
                    sign = -stack.peek();
                } else if (c == '(') {
                    stack.push(sign);
                } else if (c == ')') {
                    stack.pop();
                }
            }
        }
        if (num != 0) result += num;
        return result;
    }

    public int calculate_2(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (char c : chars) {
            if (c == ' ') continue;
            if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = - 1;
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                result += num;
                sign = stack.pop();
            } else {
                num = num * 10 + (c - '0');
            }
        }

        return result;
    }


}
