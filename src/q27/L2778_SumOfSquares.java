package q27;

/**
 * 2778. Sum of Squares of Special Elements
 * 特殊元素平方和
 */
public class L2778_SumOfSquares {

    /**
     * 方法一：遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) sum += nums[i] * nums[i];
        }
        return sum;
    }
}
