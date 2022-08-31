package q6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * Find K Closest Elements
 * https://leetcode.cn/problems/find-k-closest-elements/
 */
public class L658_FindClosestElements {

    /**
     * 方法一：排序法
     * TC: O(nlogn)
     * SC: O(logn)
     */
    public List<Integer> findClosestElements_1(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) list.add(num);
        Collections.sort(list, (a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> closest = list.subList(0, k);
        Collections.sort(closest);
        return closest;
    }

    /**
     * 方法二：模拟法
     * TC: O(n)
     * SC: O(n)
     */
    public List<Integer> findClosestElements_2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int size = arr.length;
        if (x <= arr[0]) {
            for (int i = 0; i < size && i < k; i++) list.add(arr[i]);
            return list;
        }
        if (x >= arr[size - 1]) {
            for (int i = (size - k < 0 ? 0 : size - k); i < size; i++) list.add(arr[i]);
            return list;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < size - 1; i++) {
            if (x >= arr[i] && x < arr[i + 1]) {
                if (x - arr[i] <= arr[i + 1] - x) {
                    left = right = i;
                } else {
                    left = right = i + 1;
                }

                while (k-- > 1) {
                    if (left == 0) {
                        if (right < size - 1) right++;
                        continue;
                    }
                    if (right == size - 1) {
                        if (left > 0) left--;
                        continue;
                    }

                    if (left > 0 && right < size - 1) {
                        if (x - arr[left - 1] <= arr[right + 1] - x) {
                            left--;
                        } else {
                            right++;
                        }
                    }
                }
                break;
            }
        }
        for (int i = left; i <= right; i++) list.add(arr[i]);

        return list;
    }
}
