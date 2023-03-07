package q16;

/**
 * 1653. 使字符串平衡的最少删除次数
 * Minimum Deletions to Make String Balanced
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced
 */
public class L1653_MinimumDeletions {

    /**
     * 方法一：替换字符串
     * TC: O(n^2)
     * SC: O(1)
     */
    public int minimumDeletions_1(String s) {
        int n = s.length();
        while (s.indexOf("ba") > -1) s = s.replaceAll("ba", "");
        return (n - s.length()) / 2;
    }

    /**
     * 方法二：枚举遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int minimumDeletions_2(String s) {
        int rightA = 0;
        int leftB = 0;
        char[] abs = s.toCharArray();
        for (char c : abs) rightA += 'b' - c;
        int min = rightA;
        for (char c : abs) {
            rightA -= 'b' - c;
            leftB += c - 'a';
            min = Math.min(min, rightA + leftB);
        }
        return min;
    }

    /**
     * 方法三：动态规划
     * TC: O(n)
     * SC: O(1)
     */
    public int minimumDeletions_3(String s) {
        int countB = 0;
        int min = 0;
        for (char c : s.toCharArray()) {
            min = Math.min(min + ('b' - c), countB);
            countB += c - 'a';
        }
        return min;
    }
}
