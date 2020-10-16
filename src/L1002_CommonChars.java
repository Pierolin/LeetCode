import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class L1002_CommonChars {
    /**
     * 方法一：数组
     */
    public List<String> commonChars(String[] A) {
        // init array
        int[] counts = new int[26];
        Arrays.fill(counts, Integer.MAX_VALUE);
        // loop word and count char
        for (String word : A) {
            int[] temp = new int[26];
            for (char letter : word.toCharArray()) {
                temp[letter - 'a']++;
            }
            // compare and update the array
            for (int i = 0; i < 26; i++) {
                counts[i] = Math.min(counts[i], temp[i]);
            }
        }

        // generate result list
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                list.add(String.valueOf((char)(i + 'a')));
            }
        }

        return list;

    }
    /**
     *
     * @param A
     * @return
     */
    public List<String> commonChars_2(String[] A) {
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
