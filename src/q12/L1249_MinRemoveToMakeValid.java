package q12;

/**
 * 1249. 移除无效的括号
 * Minimum Remove to Make Valid Parentheses
 * https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/
 */
public class L1249_MinRemoveToMakeValid {
    /**
     * 方法一：计数法
     * TC: O(n)
     * SC: O(n)
     */
    public String minRemoveToMakeValid(String s) {
        int balance = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
                sb.append(c);
            } else if (c == ')') {
                if (balance > 0) {
                    sb.append(c);
                    balance--;
                }
            } else {
                sb.append(c);
            }
        }

        String ans = sb.toString();
        while (balance-- > 0) {
            int i = ans.lastIndexOf("(");
            ans = ans.substring(0, i) + ans.substring(i + 1);
        }

        return ans;
    }
}
