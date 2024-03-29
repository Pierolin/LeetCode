package q2;

public class L278_FirstBadVersion {
    /**
     * 方法一：二分查找
     * TC: O(logn)
     * SC: O(1)
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
