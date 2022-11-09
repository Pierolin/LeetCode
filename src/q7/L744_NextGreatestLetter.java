package q7;

/**
 * 744. 寻找比目标字母大的最小字母
 * Find Smallest Letter Greater Than Target
 * https://leetcode.cn/problems/find-smallest-letter-greater-than-target/description/?envType=study-plan&id=binary-search-beginner&plan=binary-search&plan_progress=4ye10qt
 */
public class L744_NextGreatestLetter {

    /**
     * 方法一：二分查找
     * TC: O(logn)
     * SC: O(1)
     */
    public char nextGreatestLetter_2(char[] letters, char target) {
        int n = letters.length;
        if (target >= letters[n - 1]) return letters[0];

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            char c = letters[mid];
            if (c <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return letters[left];
    }

    /**
     * 方法一：线性查找
     * TC: O(n)
     * SC: O(1)
     */
    public char nextGreatestLetter_1(char[] letters, char target) {
        for (char c : letters) if (c > target) return c;
        return letters[0];
    }
}
