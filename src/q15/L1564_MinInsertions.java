package q15;

/**
 * 1541. 平衡括号字符串的最少插入次数
 * Minimum Insertions to Balance a Parentheses String
 * https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/
 */
public class L1564_MinInsertions {

    /**
     * 方法一：计数法
     * TC: O(n)
     * SC: O(1)
     */
    public int minInsertions(String s) {
        int min = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (rightCount == 1) {
                    min++;
                    rightCount = 0;
                    leftCount--;
                }
                leftCount++;
            } else {
                if (leftCount == 0) {
                    leftCount++;
                    min++;
                }
                rightCount++;
                if (rightCount == 2) {
                    rightCount = 0;
                    leftCount--;
                }
            }
        }
        min += leftCount * 2 - rightCount;
        return min;
    }
}
