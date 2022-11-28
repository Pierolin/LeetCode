package q17;

public class L1752_Check {

    /**
     * 方法二：一次遍历计算翻转次数
     * TC: O(n)
     * SC: O(1)
     */
    public boolean check_2(int[] nums) {
        int decreaseCount = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) decreaseCount++;
        }
        return decreaseCount < 2;
    }

    /**
     * 方法一：一次遍历计算翻转次数
     * TC: O(n)
     * SC: O(1)
     */
    public boolean check_1(int[] nums) {
        int decreaseCount = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < nums[i - 1]) decreaseCount++;
            if (decreaseCount > 1) return false;
            if (decreaseCount == 1 && nums[0] < num) return false;
        }
        return true;
    }
}
