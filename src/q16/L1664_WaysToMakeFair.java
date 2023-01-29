package q16;

public class L1664_WaysToMakeFair {

    /**
     * 方法一：前缀和
     * TC: O(n)
     * SC: O(1)
     */
    public int waysToMakeFair_1(int[] nums) {
        int count = 0;
        int oSum = 0;
        int eSum = 0;
        int preOSum = 0;
        int preESum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if ((i & 1)  == 0) {
                eSum += num;
            } else {
                oSum += num;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if ((i & 1)  == 0) {
                if (preESum + (oSum - preOSum) == preOSum + (eSum - preESum - num)) count++;
                preESum += num;
            } else {
                if (preOSum + (eSum - preESum) == preESum + (oSum - preOSum - num)) count++;
                preOSum += num;
            }
        }
        return count;
    }
}
