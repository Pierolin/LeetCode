package q27;

/**
 * 2786. Visit Array Positions to Maximize Score
 * 访问数组中的位置使分数最大
 */
public class L2786_MaxScore {
    /**
     * 
     * @param nums
     * @param x
     * @return
     */
    public long maxScore_1(int[] nums, int x) {
        int n = nums.length;
        int first = nums[0];
        long maxOdd = Integer.MIN_VALUE;
        long maxEven = Integer.MIN_VALUE;
        long[] dp = new long[n];
        dp[0] = first;
        if (first % 2 == 0) {
            maxOdd = first;
        } else {
            maxEven = first;
        }

        for (int i = 1; i < n; i++) {
            long odd;
            long even;
            int num = nums[i];
            if (num % 2 == 0) {
                odd = maxOdd +  num;
                even = maxEven +  num - x;
                dp[i] = Math.max(odd, even);
                maxOdd = Math.max(dp[i], maxOdd);
            } else {
                odd = maxOdd + num - x;
                even = maxEven +  num;
                dp[i] = Math.max(odd, even);
                maxEven = Math.max(dp[i], maxEven);
            }
        }
        return Math.max(maxOdd, maxEven);
    }

    public long maxScore_2(int[] nums, int x) {
        int first = nums[0];
        long[] dp = new long[]{first, first};
        dp[1 - first & 1] -= x;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int oe = num & 1;
            dp[oe] = num + Math.max(dp[oe], dp[1 - oe] - x);
        }
        return Math.max(dp[0], dp[1]);

    }
}
