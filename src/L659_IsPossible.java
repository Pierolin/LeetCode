import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 659. 分割数组为连续子序列
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 */
public class L659_IsPossible {
    /**
     * 方法一：贪心算法
     * Time: O(n)
     * Space: O(n)
     * 解题思路：
     */
    public boolean isPossible_2(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Integer> tailMap = new HashMap<>();

        for (int x : nums) numMap.put(x, numMap.getOrDefault(x, 0) + 1);

        for (int x : nums) {
            int count = numMap.getOrDefault(x, 0);
            if (count > 0) {
                int preEndCount = tailMap.getOrDefault(x - 1, 0);
                if (preEndCount > 0) {
                    tailMap.put(x - 1, preEndCount - 1);
                    tailMap.put(x, tailMap.getOrDefault(x, 0) + 1);
                    numMap.put(x, count - 1);
                } else {
                    int count1 = numMap.getOrDefault(x + 1, 0);
                    int count2 = numMap.getOrDefault(x + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        numMap.put(x, count - 1);
                        numMap.put(x + 1, count1 - 1);
                        numMap.put(x + 2, count2 - 1);
                        tailMap.put(x + 2, tailMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 方法二：哈希表 + 优先队列(小顶堆)
     * Time: O(nlogn)
     * Space: O(n)
     * 解题思路：
     * 1. 当 x 在数组中时，如果存在一个子序列以 x−1 结尾，长度为 k，则可以将 x 加入该子序列中，得到长度为 k+1 的子序列。如果不存在以 x−1 结尾的子序列，则必须新建一个只包含 x 的子序列，长度为 1;
     * 2. 当 x 在数组中时，如果存在多个子序列以 x−1 结尾，应该将 x 加入其中的哪一个子序列？由于题目要求每个子序列的长度至少为 3，显然应该让最短的子序列尽可能长，因此应该将 x 加入其中最短的子序列;
     * 3. 哈希表的键为子序列的最后一个数字，值为最小堆，用于存储所有的子序列长度，最小堆满足堆顶的元素是最小的，因此堆顶的元素即为最小的子序列长度。
     */
    public boolean isPossible_3(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int x : nums) {
            if (!map.containsKey(x)) map.put(x, new PriorityQueue<>());

            if (map.containsKey(x - 1)) {
                PriorityQueue<Integer> queue = map.get(x - 1);
                map.get(x).offer(queue.poll() + 1);
                if (queue.isEmpty()) map.remove(x - 1);
            } else {
                map.get(x).offer(1);
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().peek() < 3) return false;
        }

        return true;
    }
}
