package q24;

/**
 * 2469. 温度转换
 * Convert the Temperature
 * https://leetcode.cn/problems/convert-the-temperature
 */
public class L2469_ConvertTemperature {
    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin, fahrenheit};
    }
}
