package q22;

/**
 * 2293. 极大极小游戏
 * Min Max Game
 * https://leetcode.cn/problems/min-max-game/description/
 */
public class L2293_MinMaxGame {

    /**
     * 方法一：模拟迭代
     * TC: O(n)
     * sc: O(1)
     */
    public int minMaxGame_1(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            n /= 2;
            int[] newNums = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    newNums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }

    /**
     * 方法二：位运算
     * TC: O(n)
     * sc: O(1)
     */
    public int minMaxGame_2(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            n >>= 1;
            for (int i = 0; i < n; i++) {
                int j = i << 1;
                int a = nums[j];
                int b = nums[j + 1];
                nums[i] = (i & 1) == 0 ? Math.min(a, b) : Math.max(a, b);
            }
        }
        return nums[0];
    }

    /**
     * 方法三：原地修改
     * TC: O(n)
     * SC: O(1)     *
     */
    public int minMaxGame_3(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            n /= 2;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    nums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
        }
        return nums[0];
    }

    /**
     * 方法四：递归
     * TC: O(1)
     * SC: O(1)
     */
    public int minMaxGame_4(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        n /= 2;
        int[] newNums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
            } else {
                newNums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
            }
        }
        return minMaxGame_2(newNums);
    }
}
