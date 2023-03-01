package q12;

/**
 * 1247. 交换字符使得字符串相同
 * Minimum Swaps to Make Strings Equal
 * https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal
 */
public class L1247_MinimumSwap {
    /**
     * 方法一：贪心
     * TC: O(n)
     * SC: O(1)
     */
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) continue;
            if (arr1[i] == 'x') {
                xy++;
            } else {
                yx++;
            }
        }
        int diff = xy + yx;
        if (diff % 2 == 1) return -1;
        return diff / 2 + xy % 2;
    }
}
