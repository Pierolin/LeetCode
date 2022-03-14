package q2;

import java.util.Stack;

public class L224_Calculate {
    /**
     * 方法二：栈 (把括号前的计算结号和+-号操作符存入栈内)
     * Time: O(n)
     * Space: O(n)
     * 解题关键：
     * 1.
     */
    public int calculate_1(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
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

    /**
     * 方法二：栈 (把括号前的计算结号和+-号操作符存入栈内)
     * Time: O(n)
     * Space: O(n)
     * 解题关键：
     * 1. 遇到 "(" 号，把 "(" 号前的结果和操作符号存入栈；
     * 2. 遇到 ")" 号，把 ")" 号前和 "(" 号后的计算结果妈括号内的结果与栈内的结果进行计算
     */
    public int calculate_2(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') continue;
            if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                num = 0;
                sign = 1;
            } else if (c == ')') {
                sign = stack.pop();
                result = stack.pop() + sign * result;
            } else {
                num = num * 10 + (c - '0');
                if (i == chars.length - 1 || !(chars[i + 1] >= '0' && chars[i + 1] <= '9')) {
                    result = result + sign * num;
                    num  = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        L224_Calculate calculate = new L224_Calculate();
        String str = "- (3 + (4 + 5))";
        int result = calculate.calculate_2(str);
        System.out.println(result);
    }


}
