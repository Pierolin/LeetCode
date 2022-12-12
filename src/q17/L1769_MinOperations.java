package q17;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 * Minimum Number of Operations to Move All Balls to Each Box
 * https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/
 */
public class L1769_MinOperations {
    /**
     * 方法一：暴力双循环模拟
     * TC: O(n^2)
     * SC: O(1）
     */
    public int[] minOperations_1(String boxes) {
        int n = boxes.length();
        int[] mins = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') mins[i] += Math.abs(j - i);
            }
        }
        return mins;
    }

    /**
     * 方法二：数学计算
     * TC: O(n)
     * SC: O(1)
     */
    public int[] minOperations_2(String boxes) {
        int n = boxes.length();
        int[] mins = new int[n];
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                sum += i;
                count++;
            }
        }
        int subSum = 0;
        int subCount = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                subSum += i;
                subCount++;
            }
            int left = subCount * i - subSum;
            int right = sum - subSum - (count - subCount) * i;
            mins[i] = left + right;
        }
        return mins;
    }

    /**
     * 方法三：双指针
     * TC: O(n)
     * SC: O(1)
     */
    public int[] minOperations_3(String boxes) {
        int n = boxes.length();
        int[] mins = new int[n];
        int left = boxes.charAt(0) - '0';
        int right = 0;
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                mins[0] += i;
            }
        }
        for (int i = 1; i < n; i++) {
            mins[i] = mins[i - 1] + left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
        }
        return mins;
    }
}
