package q16;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. 设计有序流
 * Design an Ordered Stream
 * https://leetcode.cn/problems/design-an-ordered-stream/
 */
public class L1656_OrderedStream {
    String[] elements;
    int point;

    public L1656_OrderedStream(int n) {
        elements = new String[n];
        point = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList<>();
        elements[idKey - 1] = value;
        if (elements[point - 1] == null) return list;
        for (int i = point - 1; i < elements.length; i++) {
            if (elements[i] == null) {
                point = i + 1;
                break;
            }
            list.add(elements[i]);
        }
        return list;
    }
}
