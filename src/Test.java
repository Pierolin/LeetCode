import java.net.URL;
import java.util.*;

public class Test {
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

    public static void main(String[] args) {
        String a = "Hello";
        // \u000d a ="World";
        System.out.println(a);
        // \u000d a ="Hello World";
        System.out.println(a);
        Deque<String> arrayQueqe = new ArrayDeque();
        arrayQueqe.toArray();
    }

}

