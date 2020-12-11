import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. 数组的相对排序
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class L1122_RelativeSortArray {
    /**
     * 方法二：数组字典法
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 新建字典数组，把原数组的值作为新数组的下标，数组元素个数作为新数组的值。
     */
    public int[] relativeSortArray_1(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];

        for (int num : arr1) arr[num]++;
        int i = 0;
        for (int num : arr2) {
            while (arr[num]-- > 0) arr1[i++] = num;
        }

        for (int j = 0; j < arr.length; j++) {
            while (arr[j]-- > 0) arr1[i++] = j;
        }

        return arr1;
    }

    /**
     * 方法二：哈希表
     * TC: O(n)
     * SC: O(n)
     * 解题思路：
     * 1. 使用 HashMap 记录数组元素及每个数组元素数量;
     * 2. 使用 Arrays.sort 方法对数组进行部分排序。
     */
    public int[] relativeSortArray_2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        // 如果使用 TreeMap，可以不用再排序，倒数第 2 行代码可去掉，但是效率较低调，因为每插入 1 个就进行了排序调整
        // Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1) map.put(num, map.getOrDefault(num, 0) + 1);


        int i = 0;
        for (int num : arr2) {
            for (int j = 0; j < map.get(num); j++) arr1[i++] = num;
            map.remove(num);
        }

        int start = i;
        for (int num : map.keySet()) {
            for (int j = 0; j < map.get(num); j++) arr1[i++] = num;
        }
        Arrays.sort(arr1, start, arr1.length);
        return arr1;
    }
}
