package q7;

/**
 * 777. 在LR字符串中交换相邻字符
 * Swap Adjacent in LR String
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
public class L777_CanTransform {
    /**
     * 方法一：双指针
     * TC: O(n)
     * SC: O(1)
     */
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0;
        int j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) return i == j;
            char sc = start.charAt(i);
            char ec = end.charAt(j);
            if (sc != ec) return false;
            if (sc == 'L' && i < j) return false;
            if (sc == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}
