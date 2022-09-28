package q16;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 * Check Array Formation Through Concatenation
 * https://leetcode.cn/problems/check-array-formation-through-concatenation/
 */
public class L1640_CanFormArray {

    /**
     * 方法一：暴力双循环模拟
     * TC: O(n^2)
     * SC: O(1)
     */
    public boolean canFormArray_1(int[] arr, int[][] pieces) {
        for (int[] piece : pieces) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == piece[0]) {
                    for (int j = 1; j < piece.length; j++) {
                        if (++i >= arr.length || piece[j] != arr[i]) return false;
                    }
                    break;
                }
                if (i == arr.length - 1) return false;
            }
        }
        return true;
    }

    /**
     * 方法二：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public boolean canFormArray_2(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) map.put(piece[0], piece);

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) return false;
            int[] piece = map.get(arr[i]);
            for (int j = 1; j < piece.length; j++) {
                if (piece[j] != arr[++i]) return false;
            }
        }
        return true;
    }

    /**
     * 方法三：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public boolean canFormArray_3(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        map.put(arr[n - 1], 0);
        for (int i = 0; i < n - 1; i++) map.put(arr[i], arr[i + 1]);

        for (int[] piece : pieces) {
            for (int i = 0; i < piece.length; i++) {
                if (!map.containsKey(piece[i])) return false;
                if (i < piece.length - 1 && map.get(piece[i]) != piece[i + 1]) return false;
            }
        }
        return true;
    }

    /**
     * 方法四：哈希表
     * TC: O(n)
     * SC: O(n)
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int m = pieces.length;
        int[] hash = new int[110];
        for (int i = 0; i < m; i++) hash[pieces[i][0]] = i;
        for (int i = 0; i < n; ) {
            int[] cur = pieces[hash[arr[i]]];
            int len = cur.length;
            int idx = 0;
            while (idx < len && cur[idx] == arr[i + idx]) idx++;
            if (idx != len) return false;
            i += len;
        }
        return true;
    }
}
