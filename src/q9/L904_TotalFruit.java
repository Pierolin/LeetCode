package q9;

/**
 * 904. 水果成篮
 * Fruit Into Baskets
 * https://leetcode.cn/problems/fruit-into-baskets/
 */
public class L904_TotalFruit {


    /**
     * 方法一：动态规划
     * TC: O(n)
     * SC: O(1)
     */
    public int totalFruit_1(int[] fruits) {
        int type1 = fruits[0];  // 种类 1
        int type2 = -1; // 种类 2
        int lastTotal = 1; // 到上一棵树所能摘得的水果数量
        int currCount = 1; // 当前这棵树的种类所摘得的水果数量
        int maxTotal = 1;  // 到目前为止所能摘得的最大水果数量
        for (int i = 1; i < fruits.length; i++) {
            int type = fruits[i];
            if (type != type1 && type2 == -1) { // 当出现第 2 种类的树时，记住第 2 种类并给到当前这棵树所能摘得的水果数量 +1
                type2 = type;
                lastTotal++;
            } else {
                if (type == type1 || type == type2) { // 当是已有两个种类之一时，给到当前这棵树所能摘得的水果数量 +1
                    lastTotal++;
                } else { // 当出现第 3 种类时，把第 3 种类置为第 2 种类，原上一棵树的种类置为第 1 种类，此时到当前这棵树所能摘得的水果数量为上一棵树种类的数量 + 1
                    lastTotal = currCount + 1;
                    type1 = fruits[i - 1];
                    type2 = type;
                }
            }

            maxTotal = Math.max(maxTotal, lastTotal);
            currCount = (type == fruits[i - 1]) ? ++currCount : 1; // 如果当前这棵树的种类与上一棵种类一致，就 ++currCount，否则重新记录当前种类的数量
        }
        return maxTotal;
    }
}
