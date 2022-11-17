package q18;

public class L1855_MaxDistance {
    /**
     * 方法一：双指针
     * TC: O(n)
     * SC: O(1)
     */
    public int maxDistance_2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] > nums2[j]) i++;
            j++;
        }
        j--;
        return j - i > 0 ? j - i : 0;
    }

    /**
     * 方法一：二分查找
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int maxDistance_1(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = binarySearch(nums2, nums1[i]);
            max = Math.max(max, j - i);
        }
        return max;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = arr[mid];
            if (num >= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
