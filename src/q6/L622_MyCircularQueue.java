package q6;

/**
 * 622. 设计循环队列
 * Design Circular Queue
 * https://leetcode.cn/problems/design-circular-queue/
 */
public class L622_MyCircularQueue {

    private int size;
    private int head;
    private int tail;
    private int[] elements;
    public L622_MyCircularQueue(int k) {
        size = k;
        elements  = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        elements[tail % size] = value;
        tail++;
        return tail >= 0;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        return head >= 0;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return elements[head % size];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return elements[(tail - 1) % size];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == size;
    }
}
