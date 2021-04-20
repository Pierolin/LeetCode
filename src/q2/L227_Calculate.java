package q2;

import java.util.Stack;

public class L227_Calculate {
    /**
     * 方法一：栈
     * Time: O(n)
     * Space: O(n)
     * 解题关键：
     * 1. 把等式看作各个数字相加, 把这些数字一一存入栈内;
     * 2. 判断当前数的运算符，如果是 + 则为正数，如果是 - 则为负数，如果是 * 则当前数与栈顶元素相乘后替换栈顶元素，如果是 / 则栈顶元素除以当前数后替换栈顶元素。
     */
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int len = chars.length;
        int sign = '+';
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == ' ') continue;
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i == len - 1 || !isDigit(chars[i + 1])) {
                    if (sign == '+') stack.push(num);
                    if (sign == '-') stack.push(-num);
                    if (sign == '*') stack.push(stack.pop() * num);
                    if (sign == '/') stack.push(stack.pop() / num);
                    num = 0;
                }
            } else {
                sign = c;
            }
        }

        int result = 0;
        for (int n : stack) {
            result += n;
        }

        return result;
    }

    private boolean isDigit(char c) {
        int num = c - '0';
        return num >= 0 && num <= 9;
    }
}
