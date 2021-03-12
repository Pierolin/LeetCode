import java.net.URL;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Thread.currentThread().getThreadGroup().getParent().list();
    }


    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for (char c : S.toCharArray()) {
            if (top > - 1 && sb.charAt(top) == c) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(c);
                top++;
            }
        }
        return sb.toString();
    }

}

