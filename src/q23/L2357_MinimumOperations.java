package q23;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L2357_MinimumOperations {
    /**
     * 方法一：排序双循环
     * TC: O(n^2)
     * SC: O(1)
     */
    public int minimumOperations_1(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num > 0) {
                for (int j = i; j < n; j++) {
                    nums[j] -= num;
                }
                count++;
            }

        }
        return count;
    }

    /**
     * 方法二：排序单循环
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int minimumOperations_2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int substracts = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] - substracts;
            if (num > 0) {
                substracts += num;
                count++;
            }
        }
        return count;
    }

    /**
     * 方法三：哈希
     * TC: O(n)
     * SC: O(1)
     */
    public int minimumOperations_3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        return set.size();
    }

    /**
     * 方法四：数组哈希
     * TC: O(n)
     * SC: O(1)
     */
    public int minimumOperations_4(int[] nums) {
        boolean[] arr = new boolean[101];
        int count = 0;
        for (int i : nums) {
            if (i > 0 && !arr[i]) {
                arr[i] = true;
                count++;
            }
        }
        return count;
    }
}
