package q9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 989. 数组形式的整数加法 (Add to Array-Form of Integer)
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 */
public class L989_AddToArrayForm {

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        //List<Integer> list = new ArrayList<>();
        int i = A.length - 1;
        int add = 0;
        while (i > -1 || K > 0) {
            int sum = (i > -1 ? A[i] : 0) + (K % 10) + add;
            list.addFirst(sum % 10);
            //list.add(0, sum % 10);
            add = sum / 10;
            i--;
            K /= 10;
        }

        if (add > 0) list.addFirst(add);
        //if (add > 0) list.add(0, add);
        //Collections.reverse(list);
        /*
        int size = list.size();
        for (int i = 0; i < size / 2; i++){
            int temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
         */
        return list;
    }
}
