package q7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 84. 字母大小写全排列
 * Letter Case Permutation
 * https://leetcode.cn/problems/letter-case-permutation/
 */
public class L784_LetterCasePermutation {
    /**
     * 方法三：回溯 + 深度优先搜索（DFS)
     * TC: O(n2^n)
     * SC: O(n)
     */
    char[] chars;
    int n = 0;
    List<String> list = new ArrayList<>();

    public List<String> letterCasePermutation_3(String s) {
        chars = s.toCharArray();
        n = chars.length;
        dfs(0);
        return list;
    }

    private void dfs(int i) {
        while (i < n && Character.isDigit(chars[i])) i++;
        if (i == n) {
            list.add(new String(chars));
        } else {
            dfs(i + 1);
            chars[i] ^= 32;
            dfs(i + 1);
        }
    }

    /**
     * 方法二：广度优先搜索（BFS)
     * TC: O(n2^n)
     * SC: O(n2^n)
     */
    public List<String> letterCasePermutation_2(String s) {
        List<String> list = new ArrayList<>();
        Deque<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            int len = curr.length();
            if (len == s.length()) {
                list.add(curr.toString());
                queue.poll();
            } else {
                char c = s.charAt(len);
                if (Character.isLetter(c)) {
                    queue.offer(new StringBuilder(curr).append((char) (c ^ 32)));
                }
                curr.append(c);
            }
        }
        return list;
    }

    /**
     * 方法一：暴力枚举
     * TC: O(n2^n)
     * SC: O(n2^n)
     */
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < n; i++) {
            int size = list.size();
            char c = chars[i];
            String letter = String.valueOf(c);
            for (int j = 0; j < size; j++) {
                String str = list.get(j);
                //if (c - '0' > 9) {
                if (Character.isLetter(c)) {
                    list.set(j, str + letter.toUpperCase());
                    list.add(str + letter.toLowerCase());
                } else {
                    list.set(j, str + letter);
                }
            }
        }
        return list;
    }
}
