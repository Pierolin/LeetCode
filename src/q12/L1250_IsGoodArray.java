package q12;

/**
 * 1250. 检查「好数组」
 * Check If It Is a Good Array
 * https://leetcode.cn/problems/check-if-it-is-a-good-array
 */
public class L1250_IsGoodArray {
    /**
     * 方法一：数论(裴蜀定理)
     * TC: O(n+logm)
     * SC: O(1)
     */
    public boolean isGoodArray(int[] nums) {
        int g = nums[0];
        for (int n : nums) {
            g = gcd(g, n);
            if (g == 1) return true;
        }
        return false;
    }

    private int gcd(int a, int b){
        int mod = b % a;
        return mod == 0 ? a : gcd(mod, a);
    }
}
