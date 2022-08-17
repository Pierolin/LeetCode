package q14;

public class L1422_MaxScore {
    /**
     * 方法一： 模拟 (两次循环）
     * TC: O(n)
     * SC: 0(1)
     */
    public int maxScore(String s) {
        int max = 0;
        int left0 = 0;
        int right1 = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '1') right1++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                left0++;
            } else {
                right1--;
            }
            max = Math.max(max, left0 + right1);
        }
        return max;
    }

    /**
     * 方法二： 模拟 (一次循环）
     * TC: O(n)
     * SC: 0(1)
     */
    public int maxScore_2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = chars[0] == '0' ? 1 : 0;
        int right = 0;
        int max = left + right;
        for (int i = 1; i < len - 1; ++i) {
            if (chars[i] == '1') {
                right--;
            } else {
                left++;
                max = Math.max(max, left + right);
            }
        }
        return max - right + (chars[len - 1] == '1' ? 1 : 0);
    }

    /**
     * 方法三：前缀和 (两次循环）
     * TC: O(n)
     * SC: O(n)
     */

    public int maxScore_3(String s) {
        int len = s.length();
        int subMax = -len;
        int preSum = 0;
        for (int i = 1; i < len + 1; i++) {
            preSum = preSum + (s.charAt(i - 1) == '0' ? 1 : 0);
            if (i < len) subMax = Math.max(2 * preSum - i, subMax);
        }
        int max = subMax + len - preSum;
        return max;
    }

    /**
     * 方法四：前缀和 (一次循环）
     * TC: O(n)
     * SC: O(n)
     */

    public int maxScore_4(String s) {
        int len = s.length();
        int max = 0;
        int presum = 0;
        for (int i = 1; i < len - 1; i++) {
            max = Math.max(2 * presum - i, max);
            presum = presum + (s.charAt(i - 1) == '0' ? 1 : 0);
        }
        return max + len - presum;
    }
}
