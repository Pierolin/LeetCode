package LCP;

/**
 * LCP 06. 拿硬币
 * https://leetcode.cn/problems/na-ying-bi/
 */
public class L06_MinCount {

    public int minCount(int[] coins) {
        int min = 0;
        // for (int coin : coins) min += coin / 2 + coin % 2;
        for (int coin : coins) min += (coin >> 1) + (coin & 1);
        return min;
    }
}
