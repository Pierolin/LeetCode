package q9;

/**
 * 921. 使括号有效的最少添加
 * Minimum Add to Make Parentheses Valid
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 */
public class L921_MinAddToMakeValid {
    /**
     * 方法一：计数法
     * TC: O(n)
     * SC: O(1)
     */
    public int minAddToMakeValid(String s) {
        int leftCount = 0;
        int rightCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    rightCount++;
                }
            }
        }

        return leftCount + rightCount;
    }
}
