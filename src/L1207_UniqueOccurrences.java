import java.util.*;

/**
 * 1207. 独一无二的出现次数
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class L1207_UniqueOccurrences {


    /**
     * 方法一：双数组
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     */
    public boolean uniqueOccurrences_1(int[] arr) {
        int[] nums = new int[2001];
        for (int i : arr) {
            nums[i]++;
        }

        boolean[] existed = new boolean[arr.length + 1];
        for (int num : nums) {
            if (num == 0) continue;
            if (existed[num]) return false;
            existed[num] = true;
        }

        return true;
    }

    /**
     * 方法二：哈希
     * TC: O(n)
     * SC: O(n)
     */
    public boolean uniqueOccurrences_2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
        /** 另一种写法 **/
        /*
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) return false;
            set.add(entry.getValue());
        }
        return true;
        */
    }


    /**
     * 方法三：排序 + 数组
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 先对原数组进行排序，相同的数就靠在一起;
     * 2. 创建一新的布尔数组用以存储某一次数是否已存在，下标即为次数。
     */
    public boolean uniqueOccurrences_3(int[] arr) {
        if (arr.length < 2) return true;

        Arrays.sort(arr);
        boolean[] existed = new boolean[arr.length + 1];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (existed[count]) return false;
                existed[count] = true;
                count = 1;
            }
            if (i == arr.length - 1 && existed[count]) return false;
        }

        return true;
    }
}
