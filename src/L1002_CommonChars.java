import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class L1002_CommonChars {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        outer:
        for (char c : A[0].toCharArray()) {
            for (String word : A) {
                if (word.indexOf(c) == -1) continue outer;
            }
            list.add(String.valueOf(c));
            for (int i = 1; i < A.length; i++) {
                int idx = A[i].indexOf(c);
                A[i] = A[i].substring(0, idx) + A[i].substring(idx + 1);
            }
        }
        return list;
    }
}
