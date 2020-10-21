import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class L143_ReorderList {
    /**
     * 方法一：
     */
    public void reorderList_1(ListNode head) {

    }
    /**
     * 方法二：双端队列 Deque
     */
    public void reorderList_2(ListNode head) {
        if (head == null) return;

        Deque<ListNode> deque = new ArrayDeque();
        deque.add(head);
        while (head.next != null) {
            deque.addLast(head.next);
            head = head.next;
        }

        head = deque.pollFirst();
        int flag = 1;
        while (!deque.isEmpty()) {
            flag *= -1;
            head.next = flag == 1 ? deque.pollFirst() : deque.pollLast();
            head = head.next;
        }
        head.next = null;

    }

    /**
     * 方法三：列表 List 双指针
     * @param head
     */
    public void reorderList_3(ListNode head) {
        if (head == null || head.next == null) return;

        List<ListNode> list = new ArrayList();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            list.get(l).next = list.get(r);
            l++;
            if (l == r) break;
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;
    }
}
