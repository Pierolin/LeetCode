/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 */
public class L860_LemonadeChange {
    /**
     * 贪心算法
     * Time: O(n)
     * Space: O(1)
     * 关键思路：
     * 1. 对收钱箱里的 5 元和 10 元分别实时计数判断是否找得开;
     * 2. 收到 20 元时要优先使用 10+5 元来找，没有 10 元，再考虑用 5*3 来找, 这就是所谓的““贪心算法””吗？
     */
    public boolean lemonadeChange(int[] bills) {
        int bill5 = 0;
        int bill10 = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    bill5++;
                    break;
                case 10:
                    if (bill5 == 0) return false;
                    bill10++;
                    bill5--;
                    break;
                case 20:
                    if (bill10 > 0 && bill5 > 0) {
                        bill10--;
                        bill5--;
                    } else if (bill5 > 2) {
                        bill5 -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
