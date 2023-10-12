package q25;

/**
 * 2562. Find the Array Concatenation Value
 * 找出数组的串联值
 * https://leetcode.cn/problems/find-the-array-concatenation-value
 */
public class L2562_FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long ans = n % 2 == 0 ? 0 : nums[n / 2];
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            //val += Itteger.parseInt(nums[i] + "" + nums[j]); // Solution 1
            //val += Integer.parseInt(Integer.toString(nums[i] + Integer.toString(nums[j]))); // Solution 2
            //int times = Integer.toString(nums[j]).length(); // Solution 3
            ans += nums[i] * Math.pow(10, calTimes(nums[j])) + nums[j];
        }
        return ans;
    }

    private int calTimes(int num) {
        int times = 0;
        int temp = num;
        while (temp > 0) {
            times++;
            temp /= 10;
        }
        return times;
    }
}
