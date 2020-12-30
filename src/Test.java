import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.println("请输入str1");
        String str1 = scanner.nextLine();
        System.err.println("请输入str2");
        String str2 = scanner.nextLine();
        System.err.println("str1 == str2 :" + (str1 == str2));
        System.err.println("str1 equals str2 :" + (str1.equals(str2)));
    }

}