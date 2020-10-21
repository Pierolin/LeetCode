import java.util.Arrays;
import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class L844_BackspaceCompare {
    /**
     * 方法一：双指针实时比对
     * TC: O(n)
     * SC: O(1)
     */
    public boolean backspaceCompare_1(String S, String T) {
        char[] charsS = S.toCharArray();
        char[] charsT = T.toCharArray();
        int indexS = charsS.length - 1;
        int indexT = charsT.length - 1;

        while (indexS >= 0 || indexT >= 0) {
            indexS = getValidIndex(charsS, indexS);
            indexT = getValidIndex(charsT, indexT);
            if (indexS >= 0 && indexT >= 0 && charsS[indexS] != charsT[indexT]) return false;
            if ((indexS < 0 && indexT >= 0) || (indexS >= 0 && indexT < 0)) return false;
            indexS--;
            indexT--;
        }

        return true;
    }

    private int getValidIndex(char[] chars, int i) {
        int count = 0;
        for (; i > -1; i--) {
            if (chars[i] == '#') {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
                continue;
            }
            break;
        }
        return i;
    }

    /**
     * 方法二：倒序 + StringBuilder
     * TC: O(n)
     * SC: O(n)
     */
    public boolean backspaceCompare_2(String S, String T) {
        return rebuild(S).equals(rebuild(T));
    }

    /**
     * 方法三：栈
     * TC: O(n)
     * SC: O(n)
     */
    public boolean backspaceCompare_3(String S, String T) {
        return toStack(S).equals(toStack(T));
    }

    /**
     * 方法四：纯字符串处理
     * TC: O(n)
     * SC: O(n)
     */
    public boolean backspaceCompare_4(String S, String T) {
        return clear(S).equals(clear(T));
    }


    private String clear(String str) {
        int i = str.indexOf('#');
        while (i > -1) {
            str = str.substring(0, i == 0 ? 0 : i - 1) + str.substring(i + 1);
            i = str.indexOf('#');
        }
        return str;

        /*
        // 另一种字符串处理
        for (char c : str.toCharArray()) {
            if (c == '#') {
                int i = str.indexOf('#');
                str = str.substring(0, i - 1 < 0 ? 0 : i - 1) + str.substring(i+1);
            }
        }
        */

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
        System.out.println(compare.backspaceCompare_1("a#d#cf", "#a#c"));
    }
}
