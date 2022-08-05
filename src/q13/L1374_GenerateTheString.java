package q13;

/**
 * 1374. Generate a String With Characters That Have Odd Counts
 * 生成每种字符都是奇数个的字符串
 */
public class L1374_GenerateTheString {
    public String generateTheString(int n) {
        return (n & 1) == 1 ? "a".repeat(n) : "a".repeat(n - 1) + "b";
    }
}
