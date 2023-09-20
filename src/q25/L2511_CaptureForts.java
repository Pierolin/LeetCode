package q25;

/**
 * 2511. Maximum Enemy Forts That Can Be Captured
 * 最多可以摧毁的敌人城堡数目
 * https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/description/?envType=daily-question&envId=2023-09-02
 */
public class L2511_CaptureForts {
    /**
     * 方法一：逐个叠加法
     * Time: O(n)
     * Space: O(1)
     */
    public int captureForts_2(int[] forts) {
        int max = 0;
        boolean isCommand = false;
        boolean isEmpty = false;
        int count = 0;
        for (int f : forts) {
            switch (f) {
                case -1:
                    isEmpty = true;
                    if (isCommand) {
                        max = Math.max(max, count);
                        isCommand = false;
                    }
                    count = 0;
                    break;
                case 0:
                    if (isCommand || isEmpty) count++;
                    break;
                case 1:
                    isCommand = true;
                    if (isEmpty) {
                        max = Math.max(max, count);
                        isEmpty = false;
                    }
                    count = 0;
                    break;
                default:
            }
        }
        return max;
    }

    /**
     * 方法一：计算前后间隔法
     * Time: O(n)
     * Space: O(1)
     */
    public int captureForts_1(int[] forts) {
        int max = 0;
        int j = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (j > -1 && forts[j] != forts[i]) max = Math.max(max, i - j - 1);
                j = i;
            }
        }
        return max;
    }
}
