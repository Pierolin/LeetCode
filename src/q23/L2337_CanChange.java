package q23;

/**
 * 2337. 移动片段得到字符串
 * Move Pieces to Obtain a String
 * https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
 */
public class L2337_CanChange {
    /**
     * 方法一：双指针
     * TC: O(n)
     * SC: O(1)
     */
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0;
        int j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;
            if (i == n || j == n) return i == j;
            char sc = start.charAt(i);
            char tc = target.charAt(j);
            if (sc != tc) return false;
            if (sc == 'L' && i < j) return false;
            if (tc == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}

