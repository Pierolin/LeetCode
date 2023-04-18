package q0;

/**
 * 27. 移除元素
 * Remove Element
 * https://leetcode.cn/problems/remove-element
 */
public class L27_RemoveElement {
    /**
     * 方法一：双指针
     * TC: O(n)
     * SC: O(1)
     */
    public int removeElement(int[] nums, int val) {
        int j = -1;
        for (int num : nums) {
            if (num != val) nums[++j] = num;
        }
        return j + 1;
    }
}
