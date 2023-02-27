package q12;

/**
 * 1234. 替换子串得到平衡字符串
 * Replace the Substring for Balanced String
 */
public class L1234_BalancedString {
    /**
     * 方法一：动态规划 + 前缀和 + 移动窗口
     * TC: O(n^2)
     * SC: O(n)
     */
    public int balancedString_1(String s) {
        int n = s.length();
        int ave = n / 4;
        int[][] sums = new int[n][4];
        sums[0][c2i(s.charAt(0))] = 1;
        for (int i = 1; i < n; i++) {
            int j = c2i(s.charAt(i));
            sums[i] = sums[i - 1].clone();
            sums[i][j]++;
        }

        int[] overs = new int[4];
        int len = 0;
        for (int i = 0; i < 4; i++) {
            int over = sums[n - 1][i] - ave;
            if (over > 0) {
                overs[i] = over;
                len += over;
            }
        }

        if (len == 0) return 0;
        while (len <= n) {
            if (isBalanced(overs, sums[len - 1])) return len;
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                int[] windowSum = new int[]{
                        sums[j][0] - sums[i][0],
                        sums[j][1] - sums[i][1],
                        sums[j][2] - sums[i][2],
                        sums[j][3] - sums[i][3]
                };
                if (isBalanced(overs, windowSum)) return len;
            }
            len++;
        }
        return len;
    }

    /**
     * 方法二：动态规划 + 前缀和 + 移动窗口 + 二分查找
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int balancedString_2(String s) {
        int n = s.length();
        int ave = n / 4;
        int[][] sums = new int[n][4];
        sums[0][c2i(s.charAt(0))] = 1;
        for (int i = 1; i < n; i++) {
            int j = c2i(s.charAt(i));
            sums[i] = sums[i - 1].clone();
            sums[i][j]++;
        }

        int[] overs = new int[4];
        int len = 0;
        for (int i = 0; i < 4; i++) {
            int over = sums[n - 1][i] - ave;
            if (over > 0) {
                overs[i] = over;
                len += over;
            }
        }
        if (len == 0) return 0;

        int left = len;
        int right = n;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (isBalanced(mid, overs, sums)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 方法三：同向双指针
     * TC: O(n)
     * SC: O(1)
     */
    public int balancedString_3(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int ave = n / 4;
        int min = n;
        int[] counts = new int['X'];
        for (char c : arr) counts[c]++;
        if (counts['Q'] == ave && counts['W'] == ave && counts['E'] == ave && counts['R'] == ave) return 0;
        for (int l = 0, r = 0; r < n; r++) {
            counts[arr[r]]--;
            while (counts['Q'] <= ave && counts['W'] <= ave && counts['E'] <= ave && counts['R'] <= ave) {
                min = Math.min(min, r - l + 1);
                counts[arr[l++]]++;
            }
        }
        return min;
    }

    private boolean isBalanced(int len, int[] overs, int[][] sums) {
        if (isBalanced(overs, sums[len - 1])) return true;
        for (int i = 0; i + len < sums.length; i++) {
            int j = i + len;
            int[] windowSum = new int[]{
                    sums[j][0] - sums[i][0],
                    sums[j][1] - sums[i][1],
                    sums[j][2] - sums[i][2],
                    sums[j][3] - sums[i][3]
            };
            if (isBalanced(overs, windowSum)) return true;
        }
        return false;
    }

    private boolean isBalanced(int[] overs, int[] sum) {
        for (int i = 0; i < overs.length; i++) {
            if (overs[i] > sum[i]) return false;
        }
        return true;
    }

    private int c2i(char c) {
        return "QWER".indexOf(c);
    }
}
