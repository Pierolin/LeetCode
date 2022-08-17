package q6;

/**
 * 641. 设计循环双端队列
 * Design Circular Deque
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
