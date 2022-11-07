package q4;

/**
 * 481. 神奇字符串
 * Magical String
 * https://leetcode.cn/problems/magical-string/
 */
public class L481_MagicalString {

    /**
     * 方法一：双指针
     * TC: O(n)
     * SC: O(n)
     */
    public int magicalString(int n) {
        int[] nums = new int[n];
        if (n < 4) return 1;
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        int i = 3;
        int j = 2;
        int num = 1;
        int count = 1;
        while (i < n) {
            int x = nums[j++];
            while (x-- > 0) {
                nums[i++] = num;
                if (num == 1) count++;
                if (i == n) break;
            }
            // num = num == 1 ? 2 : 1;
            num ^= 3;
        }
        return count;
    }
}
