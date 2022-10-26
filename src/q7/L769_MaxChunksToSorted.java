package q7;

/**
 * 769. 最多能完成排序的块
 * Max Chunks To Make Sorted
 * https://leetcode.cn/problems/max-chunks-to-make-sorted/
 */

public class L769_MaxChunksToSorted {

    /**
     * 方法三: 贪心法
     * TC: O(n)
     * SC: O(1)
     */
    public int maxChunksToSorted_3(int[] arr) {
        int chunks = 0;
        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
            diff += arr[i] - i;
            if (diff == 0) chunks++;
        }
        return chunks;
    }

    /**
     * 方法二: 贪心法
     * TC: O(n)
     * SC: O(1)
     */
    public int maxChunksToSorted_2(int[] arr) {
        int chunks = 0;
        int sumElement = 0;
        int sumIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            sumElement += arr[i];
            sumIndex += i;
            if (sumElement == sumIndex) chunks++;
        }
        return chunks;
    }

    /**
     * 方法一: 贪心法
     * TC: O(n)
     * SC: O(1)
     */
    public int maxChunksToSorted_1(int[] arr) {
        int chunks = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, i);
            if (i == max) chunks++;
        }
        return chunks;
    }
}
