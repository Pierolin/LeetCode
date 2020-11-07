public class L941_ValidMountainArray {
    /**
     * 方法一：暴力循环
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 山峰有且只有 1 个，不能有平地或山谷。
     */
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int peakCount = 0;
        for (int i = 1; i < A.length - 1; i++) {
            // 平地
            if (A[i - 1] == A[i]) return false;
            // 山谷
            if (A[i - 1] > A[i] && A[i] < A[i + 1]) return false;
            // 山峰
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) peakCount++;
        }
        // 山峰有且只有 1 个
        return peakCount == 1;
    }

    /**
     * 方法二：双指针
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 从左右两边分别往中间高点靠，判断最高点是否是同一点。
     */
    public boolean validMountainArray_2(int[] A) {
        if (A.length < 3) return false;
        int l = 0;
        int r = A.length - 1;

        while (l < r && A[l] < A[l + 1]) l++;

        if (l == 0 || l == r) return false;

        while (A[r] < A[r - 1]) r--;

        return l == r;
    }
}
