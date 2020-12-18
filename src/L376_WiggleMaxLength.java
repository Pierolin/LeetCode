public class L376_WiggleMaxLength {
    public int wiggleMaxLength_(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    /**
     * 方法三：计数法
     * Time：O(n)
     * Space: O(1)
     * 解题思路：
     * 1. 先算出第 1 次摆动是上升还是下降；
     * 2. 连续上升或下降不算摆动，只有由上升变下降才算是摆动。
     */
    public int wiggleMaxLength_3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        boolean isUp = false;
        int max = 2;
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                isUp = nums[i] > nums[i - 1];
                n = i;
                break;
            }
        }

        for (int i = n + 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                max++;
                if (isUp && nums[i] < nums[i - 1]) {
                    isUp = false;
                } else if (!isUp && nums[i] > nums[i - 1]) {
                    isUp = true;
                }
            }
        }

        return max;
    }
}
