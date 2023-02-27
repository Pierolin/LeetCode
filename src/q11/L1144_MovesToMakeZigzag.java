package q11;

/**
 * 1144. 递减元素使数组呈锯齿状
 * Decrease Elements To Make Array Zigzag
 */
public class L1144_MovesToMakeZigzag {

    /**
     * 方法一：模拟 + 贪心 (减少前后数)
     * TC: O(n)
     * SC: O(1)
     */
    public int movesToMakeZigzag_1(int[] nums) {
        return Math.min(moveCount(nums, 0), moveCount(nums, 1));
    }

    private int moveCount(int[] nums, int start) {
        int moves = 0;
        int n = nums.length;
        int prev = (start == 0 ? 0 : nums[start - 1]);
        for (int i = start; i < n; i += 2) {
            int num = nums[i];
            if (prev >= num) moves += prev - num + 1;
            int next = (i == n - 1 ? 0 : nums[i + 1]);
            if (next >= num) {
                moves += next - num + 1;
                prev = num - 1;
            } else {
                prev = next;
            }
        }
        return moves;
    }

    /**
     * 方法一：模拟 + 贪心 (减少当前数)
     * TC: O(n)
     * SC: O(1)
     */
    public int movesToMakeZigzag_2(int[] nums) {
        return Math.min(countMoves(nums, 0), countMoves(nums, 1));
    }

    public int countMoves(int[] nums, int start) {
        int count = 0;
        int n = nums.length;
        for (int i = start; i < n; i += 2) {
            int curr = nums[i];
            int prev = (i == 0 ? Integer.MAX_VALUE : nums[i - 1]);
            int next = (i == n - 1 ? Integer.MAX_VALUE : nums[i + 1]);
            int min = Math.min(prev, next);
            if (curr >= min) count += curr - min + 1;
        }
        return count;
    }
}
