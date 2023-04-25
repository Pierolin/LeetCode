package q24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * 2418. 按身高排序
 * Sort the People
 * https://leetcode.cn/problems/sort-the-people
 */
public class L2418_SortPeople {
    /**
     * 方法一：二维数组排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public String[] sortPeople_1(String[] names, int[] heights) {
        int n = names.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[]{i, heights[i]};
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) ans[i] = names[arr[i][0]];
        return ans;
    }

    /**
     * 方法二：TreeMap
     * TC: O(nlogn)
     * SC: O(n)
     */
    public String[] sortPeople_2(String[] names, int[] heights) {
        int n = names.length;
        TreeMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) map.put(heights[i], names[i]);
        String[] ans = new String[n];
        int i = 0;
        for (String name : map.values()) ans[i++] = name;
        return ans;
    }

    /**
     * 方法三：一维数组排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public String[] sortPeople_3(String[] names, int[] heights) {
        int n = names.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (a, b) -> heights[b] - heights[a]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) ans[i] = names[ids[i]];
        return ans;
    }

    /**
     * 方法四：Stream
     * TC: O(nlogn)
     * SC: O(n)
     */
    public String[] sortPeople_4(String[] names, int[] heights) {
        return Stream.iterate(0, i -> i + 1)
                .limit(names.length)
                .sorted(Comparator.<Integer>comparingInt(i -> heights[i]).reversed())
                .map(i -> names[i])
                .toArray(String[]::new);
    }
}
