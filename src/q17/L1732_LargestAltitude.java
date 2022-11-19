package q17;

/**
 * 1732. 找到最高海拔
 * Find the Highest Altitude
 * https://leetcode.cn/problems/find-the-highest-altitude/description/
 */
public class L1732_LargestAltitude {
    /**
     * 方法一：前缀和（差分数组）
     * TC: O(n)
     * SC: O(1)
     */
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int largest = 0;
        for (int g : gain) {
            alt += g;
            largest = Math.max(largest, alt);
        }
        return largest;
    }
}
