package q6;

/**
 * 640. 求解方程
 * Solve the Equation
 * https://leetcode.cn/problems/solve-the-equation/
 */
public class L640_SolveEquation {
    /**
     * 方法一：模擬
     * TC: O(n)
     * SC: O(1)
     */
    public String solveEquation(String equation) {
        if (equation == null) return null;

        int sumX = 0; // x 的系数之和
        int sumC = 0;  // 常数项之和
        int sign = 1; // 符号
        int number = 0; // x 的系统或常数项
        boolean isLeft = true; // 是否等号左边
        equation = equation.replaceAll("0x", "0"); // 替换无效项 0x 为 0。

        for (char c : equation.toCharArray()) {
            switch (c) {
                case 'x':
                    sumX += (number == 0 ? 1 : number) * sign;
                    number = 0;
                    break;
                case '=':
                    sumC += number * sign;
                    sign = -1;
                    number = 0;
                    isLeft = false;
                    break;
                case '+':
                    sumC += number * sign;
                    sign = isLeft ? 1 : -1;
                    number = 0;
                    break;
                case '-':
                    sumC += number * sign;
                    sign = isLeft ? -1 : +1;
                    number = 0;
                    break;
                default:
                    number = number * 10 + (c - '0');
            }
        }
        sumC += number * sign;

        if (sumX == 0) return sumC == 0 ? "Infinite solutions" : "No solution";
        int x = -sumC / sumX;
        return "x=" + x;
    }


    public static void main(String[] args) {
        L640_SolveEquation se = new L640_SolveEquation();
        //String result = se.solveEquation("x+5-3+x=6+x-2");
        String result = se.solveEquation("x=x");
        System.out.println(result);
    }

}
