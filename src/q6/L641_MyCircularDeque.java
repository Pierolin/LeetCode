package q6;

/**
 * 641. 设计循环双端队列
 * Design Circular Deque
 */

/**
 * 方法一：数组
 * TC: O(1)
 * SC: O(n)
 */
public class L641_MyCircularDeque {
    int capacity;
    int size;
    int[] elements;
    int front;
    int rear;

    public L641_MyCircularDeque(int k) {
        elements = new int[k];
        capacity = k;
        size = 0;
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return elements[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * 方法一：钟表
 * TC: O(1)
 * SC: O(n)
 */
class MyCircularDeque {
    class DLinkNode {
        int val;
        DLinkNode prev, next;

        public DLinkNode(int val) {
            this.val = val;
        }
    }

    int capacity;
    int size;
    DLinkNode front, rear;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        DLinkNode node = new DLinkNode(value);
        if (size == 0) {
            front = rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        DLinkNode node = new DLinkNode(value);
        if (size == 0) {
            rear = front = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = front.next;
        if (front != null) front.prev = null;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = rear.prev;
        if (rear != null) rear.next = null;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return front.val;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return rear.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }
}
