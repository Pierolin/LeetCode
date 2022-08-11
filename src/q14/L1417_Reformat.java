package q14;

import java.util.ArrayDeque;
import java.util.Deque;

public class L1417_Reformat {
    public String reformat(String s) {
        if (s == null || s.length() < 1) return "";

        Deque<Character> stackL = new ArrayDeque<>(); // store letters
        Deque<Character> stackD = new ArrayDeque<>(); // store digits

        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                stackL.push(c);
            } else {
                stackD.push(c);
            }
        }

        int diffLD = stackL.size() - stackD.size();
        if (Math.abs(diffLD) > 1) return "";

        StringBuilder sb = new StringBuilder();

        while (!stackL.isEmpty() && !stackD.isEmpty()) {
            if (diffLD >= 0) {
                sb.append(stackL.pop());
                sb.append(stackD.pop());
            } else {
                sb.append(stackD.pop());
                sb.append(stackL.pop());
            }
        }
        if (diffLD > 0) sb.append(stackL.pop());
        if (diffLD < 0) sb.append(stackD.pop());

        return sb.toString();
    }
}
