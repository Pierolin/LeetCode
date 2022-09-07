package q9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 * Validate Stack Sequences
 */
public class L946_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
