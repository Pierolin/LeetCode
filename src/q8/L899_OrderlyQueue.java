package q8;

import java.util.Arrays;

/**
 * 899. Orderly Queue
 * 有序队列
 */
public class L899_OrderlyQueue {
    /**
     * 方法一：脑筋急转弯
     * TC: 当 k=1 时，复杂度为 O(n)；当 k>1 时，复杂度为 O(nlogn)
     * SC: 当 k>1 时，需要使用额外的排序空间 O(logn)
     */
    public String orderlyQueue(String s, int k) {
        if (k < 1 || s.length() < 2) return s;

        if (k == 1) {
            String smallest = s;
            StringBuffer sb = new StringBuffer(s);
            for (int i = 0; i < s.length(); i++) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(smallest) < 0) smallest = sb.toString();
            }
            return smallest;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
