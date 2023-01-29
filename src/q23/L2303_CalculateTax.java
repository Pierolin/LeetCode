package q23;

/**
 * 2303. 计算应缴税款总额
 * Calculate Amount Paid in Taxes
 * https://leetcode.cn/problems/calculate-amount-paid-in-taxes/description/
 */
public class L2303_CalculateTax {
    /**
     * 方法一：模拟法
     * TC: O(n)
     * SC: O(1)
     */
    public double calculateTax(int[][] brackets, int income) {
        int tax = 0;
        int last = 0;
        for (int[] b : brackets) {
            int upper = b[0];
            int percent = b[1];
            tax += (Math.min(income, upper) - last) * percent;
            if (income < upper) break;
            last = upper;
        }
        return tax / 100.0;
    }
}
