package q18;

/**
 * 1822. 数组元素积的符号
 * Sign of the Product of an Array
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 */
public class L1822_ArraySign {
    /**
     * 方法二：模拟遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int arraySign_2(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) sign *= -1;
        }
        return sign;
    }

    /**
     * 方法一：模拟遍历
     * TC: O(n)
     * SC: O(1)
     */
    public int arraySign_1(int[] nums) {
        int negatives = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) negatives++;
        }
        return negatives % 2 == 0 ? 1 : -1;
    }
}
