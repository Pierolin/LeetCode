package q25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L6316_MaxScore {
    /**
     * 方法一：全局排序
     * TC: O(nlogn)
     * SC: O(1)
     */
    public int maxScore_1(int[] nums){
        Arrays.sort(nums);
        int score = 0;
        long sum = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            sum += nums[i];
            if (sum <= 0) break;
            score++;
        }
        return score;
    }

    /**
     * 方法二：部分排序
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int maxScore_2(int[] nums) {
        long sum = 0;
        int score = 0;
        List<Integer> negativeList = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                sum += num;
                score++;
            } else {
                negativeList.add(num);
            }
        }
        Collections.sort(negativeList, (a, b) -> b - a);
        for (int num : negativeList) {
            sum += num;
            if (sum <= 0) break;
            score++;
        }
        return score;
    }
}
