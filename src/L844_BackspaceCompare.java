import java.util.Arrays;
import java.util.Stack;

public class L844_BackspaceCompare {
    /**
     * 方法一：倒着 + StringBuilder
     */
    public boolean backspaceCompare_1(String S, String T) {
        return rebuild(S).equals(rebuild(T));
    }

    /**
     * 方法二：栈
     */
    public boolean backspaceCompare_2(String S, String T) {
        return toStack(S).equals(toStack(T));
    }

    /**
     * 方法三：纯字符串处理
     */
    public boolean backspaceCompare_3(String S, String T) {
        return clear(S).equals(clear(T));
    }


    private String clear(String str) {
        /*
        for (char c : str.toCharArray()) {
            if (c == '#') {
                int i = str.indexOf('#');
                str = str.substring(0, i - 1 < 0 ? 0 : i - 1) + str.substring(i+1);
            }
        }
        */

        int i = str.indexOf('#');
        while (i > -1) {
            str = str.substring(0, i == 0 ? 0 : i - 1) + str.substring(i + 1);
            i = str.indexOf('#');
        }
        return str;

    }


    private String rebuild(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            if (chars[i] == '#') {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }


    private Stack<Integer> toStack(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push((int) c);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        L844_BackspaceCompare compare = new L844_BackspaceCompare();
        System.out.println(compare.backspaceCompare_3("a##c", "#a#c"));
    }
}
