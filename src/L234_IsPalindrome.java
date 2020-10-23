import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class L234_IsPalindrome {
    public boolean isPalindrome_2(ListNode head) {
        if (head == null || head.next == null) return true;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }

        while (!deque.isEmpty()) {
            ListNode first = deque.pollFirst();
            if (deque.isEmpty()) return true;
            ListNode last = deque.pollLast();
            if (first.val != last.val) return false;
        }
        return true;
    }

    public boolean isPalindrome_3(ListNode head) {
        if (head == null || head.next == null) return true;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l++).val != list.get(r--).val) return false;
        }
        return true;
    }
}
