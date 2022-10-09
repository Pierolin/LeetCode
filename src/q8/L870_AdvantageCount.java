package q8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class L870_AdvantageCount {
    /**
     * 方法三：
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            set.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            Integer num = set.higher(nums2[i]);
            if (num == null) num = set.first();
            ans[i] = num;
            if (map.get(num) == 1) {
                map.remove(num);
                set.remove(num);
            } else {
                map.put(num, map.get(num) - 1);
            }
        }
        return ans;
    }


    /**
     * 方法二：贪心法(田忌赛马)
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int[] advantageCount_2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int[] ans = new int[n];

        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) index[i] = i;
        Arrays.sort(index, (a, b) -> (nums2[a] - nums2[b]));

        int left = 0;
        int right = n - 1;
        for (int num : nums1) {
            int i = num > nums2[index[left]] ? index[left++] : index[right--];
            ans[i] = num;
        }

        return ans;
    }

    /**
     * 方法一：模拟二分法
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int[] advantageCount_1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];
        int minI = 0;
        for (int i = 0; i < n; i++) {
            int left = minI;
            int right = n;
            while (left != right) {
                int mid = left + ((right - left) >> 1);
                if (nums1[mid] < nums2[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            while (left < n && (visited[left] || nums1[left] == nums2[i])) left++;

            if (left == n) {
                while (visited[minI]) minI++;
                ans[i] = nums1[minI];
                visited[minI++] = true;
            } else {
                ans[i] = nums1[left];
                visited[left] = true;
            }
        }
        return ans;
    }
}
