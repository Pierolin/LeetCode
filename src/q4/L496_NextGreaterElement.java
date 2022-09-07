package q4;

/**
 * 496. 下一个更大元素 I
 * Next Greater Element I
 * https://leetcode.cn/problems/next-greater-element-i/
 */
public class L496_NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int size = nums1.length;
        int[] greaters = new int[size];
        outer: for (int i = 0; i < size; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int n = j + 1; n < nums2.length; n++) {
                        if (nums2[n] > nums2[j]) {
                            greaters[i] = nums2[n];
                            continue outer;
                        }
                    }
                    greaters[i] = -1;
                    break;
                }
            }
        }
        return greaters;
    }
}
