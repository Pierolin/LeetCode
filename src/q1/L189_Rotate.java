package q1;

public class L189_Rotate {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 1) return;

        int len = nums.length;
        k = k % len;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) temp[i] = nums[i];
        for (int i = len - 1; i > k - 1; i--) nums[(i + k) % len] = nums[i];
        for (int i = 0; i < k; i++) nums[(i + k) % len] = temp[i];
    }
}
