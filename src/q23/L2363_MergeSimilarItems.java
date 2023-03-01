package q23;

import java.util.*;

/**
 * 2363. 合并相似的物品
 * Merge Similar Items
 * https://leetcode.cn/problems/merge-similar-items
 */
public class L2363_MergeSimilarItems {

    /**
     * 方法一：數組哈希
     * TC: O(n)
     * SC: O(1)
     */
    public List<List<Integer>> mergeSimilarItems_1(int[][] items1, int[][] items2) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[1001];
        for (int[] item : items1) arr[item[0]] = item[1];
        for (int[] item : items2) arr[item[0]] += item[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) list.add(List.of(i, arr[i]));
        }
        return list;
    }

    /**
     * 方法一：哈希 + 排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public List<List<Integer>> mergeSimilarItems_2(int[][] items1, int[][] items2) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) map.put(item[0], item[1]);
        for (int[] item : items2) map.merge(item[0], item[1], Integer::sum);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            list.add(List.of(e.getKey(), e.getValue()));
        }
        list.sort((a, b) -> a.get(0) - b.get(0));
        return list;
    }

    /**
     * 方法一：排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public List<List<Integer>> mergeSimilarItems_3(int[][] items1, int[][] items2) {
        Arrays.sort(items1, (a, b) -> a[0] - b[0]);
        Arrays.sort(items2, (a, b) -> a[0] - b[0]);
        int i1 = 0;
        int i2 = 0;

        List<List<Integer>> list = new ArrayList<>();
        while (i1 < items1.length && i2 < items2.length) {
            int v1 = items1[i1][0];
            int w1 = items1[i1][1];
            int v2 = items2[i2][0];
            int w2 = items2[i2][1];
            if (v1 == v2) {
                list.add(List.of(v1, w1 + w2));
                i1++;
                i2++;
            } else if (v1 < v2) {
                list.add(List.of(v1, w1));
                i1++;
            } else {
                list.add(List.of(v2, w2));
                i2++;
            }
        }

        while (i1 < items1.length) list.add(List.of(items1[i1][0], items1[i1++][1]));
        while (i2 < items2.length) list.add(List.of(items2[i2][0], items2[i2++][1]));

        return list;
    }
}
