package q23;

/**
 * 2315. 统计星号
 * Count Asterisks
 * https://leetcode.cn/problems/count-asterisks/description/
 */
public class L2315_CountAsterisks {
    /**
     * 方法一：API 方法(indexOf, substring)
     * TC: O(n)
     * SC: O(1)
     */
    public int countAsterisks_1(String s) {
        int count = 0;
        String temp = s;
        String sign = "|";
        int i = temp.indexOf(sign);
        while (i > -1) {
            int j = temp.indexOf(sign, i + 1);
            if (j > i) {
                temp = temp.substring(0, i) + temp.substring(j + 1);
            }
            i = temp.indexOf(sign);
        }

        for (char c : temp.toCharArray()) {
            if (c == '*') count++;
        }
        return count;
    }

    /**
     * 方法二：一次遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int countAsterisks_2(String s) {
        int count = 0;
        boolean isPair = false;
        for (char c : s.toCharArray()) {
            if (c == '|') isPair = !isPair;
            if (c == '*' && !isPair) count++;
        }
        return count;
    }
}
