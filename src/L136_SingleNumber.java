/**
 * 136. Single Number
 * 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class L136_SingleNumber {
    /**
     * 方法一：异或位运算法
     * Time: O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 异或位运算：相同为 0，不同为 1;
     * 2.
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) single ^= num;
        return single;
    }
}
