package q2;

import java.util.Stack;

public class L232_MyQueue {
    Stack<Integer> mainStack;
    Stack<Integer> subStack;

    /**
     * Initialize your data structure here.
     */
    public L232_MyQueue() {
        mainStack = new Stack<Integer>();
        subStack = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!mainStack.isEmpty()) {
            subStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while (!subStack.isEmpty()) {
            mainStack.push(subStack.pop());
        }

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return mainStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return mainStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return mainStack.isEmpty();
    }
}

/**
 * 方法二
 */
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */