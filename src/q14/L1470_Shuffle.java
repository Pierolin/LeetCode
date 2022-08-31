package q14;

/**
 * 1470. 重新排列数组
 * Shuffle the Array
 * https://leetcode.cn/problems/shuffle-the-array/
 */
public class L1470_Shuffle {
    /**
     * 方法三：
     * TC: O(n)
     * SC: O(1)
     */
    public int[] shuffle_1(int[] nums, int n) {
        for (int i = 1; i < 2 * n; i++) {
            if (nums[i] > 0) {
                int j = i;
                while (nums[i] > 0) {
                    j = j < n ? 2 * j : 2 * (j - n) + 1;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = -temp;
                }
            }
        }
        for (int i = 1; i < 2 * n; i++) {
            nums[i] = -nums[i];
        }
        return nums;
    }

    /**
     * 方法二：位运算
     * TC: O(n)
     * SC: O(1)
     */
    public int[] shuffle_2(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i++) {
            int j = i < n ? 2 * i : 2 * (i - n) + 1;
            nums[j] |= (nums[i] & 1023) << 10;
        }
        for (int i = 0; i < 2 * n; i++) nums[i] >>= 10;
        return nums;
    }

    /**
     * 方法一：新建数组一次遍历
     * TC: O(n)
     * SC: O(n)
     */
    public int[] shuffle_3(int[] nums, int n) {
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[2 * i] = nums[i];
            arr[2 * i + 1] = nums[i + n];
        }
        /*
        int j = 0;
        for (int i = 0; i < n; i++) {
            arr[j++] = nums[i];
            arr[j++] = nums[i + n];
        }
        */
        return arr;
    }
}
