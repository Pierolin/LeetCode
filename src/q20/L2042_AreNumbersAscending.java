package q20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2042. 检查句子中的数字是否递增
 * Check if Numbers Are Ascending in a Sentence
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/description/
 */
public class L2042_AreNumbersAscending {

    /**
     * 方法一：模拟遍历
     * TC: O(n)
     * SC: O(1)
     */
    public boolean areNumbersAscending_1(String s) {
        int prev = -1;
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (isDigit(chars[i])) {
                int num = chars[i];
                int j = i + 1;
                while (j < n && isDigit(chars[j])) num = num * 10 + chars[j++];
                if (num <= prev) return false;
                prev = num;
                i = j;
            }
        }
        return prev > -1;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 方法二：使用 split 和 try catch
     * TC: O(n)
     * SC: O(1)
     */
    public boolean areNumbersAscending_2(String s) {
        int prev = -1;
        for (String str : s.split(" ")) {
            try {
                int num = Integer.parseInt(str);
                if (num <= prev) return false;
                prev = num;
            } catch (Exception ex) {
            }
        }
        return true;
    }

    /**
     * 方法三：使用正则表达式
     * TC: O(n)
     * SC: O(1)
     */
    public boolean areNumbersAscending_3(String s) {
        int prev = -1;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            if (num <= prev) return false;
            prev = num;
        }
        return true;
    }
}
