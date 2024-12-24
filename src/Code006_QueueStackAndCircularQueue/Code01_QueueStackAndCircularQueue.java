package Code006_QueueStackAndCircularQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code01_QueueStackAndCircularQueue {
    public static class Queue1 {
        public Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();// 队列是否为空
        }

        public void offer(int num) {
            queue.add(num);// 队尾入队
        }

        public int poll() {
            return queue.poll(); // 队头出队
        }

        public int peek() {
            return queue.peek(); // 查看队头
        }

        public int size() {
            return queue.size();
        }
    }

    public static class Queue2 {
        public int[] queue;
        public int front;
        public int rear;

        public Queue2(int n) {
            queue = new int[n];
            front = 0;
            rear = 0;
        }

        public boolean isEmpty() {
            return front == rear;// 队列是否为空
        }

        public void offer(int num) {
            queue[rear++] = num;
        }

        public int poll() {
            return queue[front++];// 队头出队
        }

        public int head() {
            return queue[front]; // 查看队头
        }

        public int tail() {
            return queue[rear];
        }

        public int size() {
            return rear - front;
        }

    }

    public static class Stack1 {
        public Stack<Integer> stack = new Stack<>();

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void push(int num) {
            stack.push(num);
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public int size() {
            return stack.size();
        }

    }

    public static class Stack2 {
        public int[] stack;
        public int top;

        public Stack2(int n) {
            stack = new int[n];
            top = 0;
        }

        public boolean isEmpty() {
            return top == 0;
        }

        public void push(int num) {
            stack[top++] = num;
        }

        public int pop() {
            return stack[--top];
        }

        public int peek() {
            return stack[top - 1];
        }

        public int size() {
            return top;
        }
    }

    // 测试链接 : https://leetcode.cn/problems/design-circular-queue/
    class MyCircularQueue {
        public int[] queue;

        public int front, rear, size, limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            front = rear = size = 0;
            limit = k;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;
            queue[rear] = value;
            rear = rear == limit - 1 ? 0 : (rear + 1);
            size++;
            return true;

        }

        public boolean deQueue() {
            if (isEmpty())
                return false;
            front = front == limit - 1 ? 0 : (front + 1);
            size--;
            return true;

        }

        public int Front() {
            if (isEmpty())
                return -1;
            return queue[front];

        }

        public int Rear() {
            if (isEmpty())
                return -1;

            int last = rear == 0 ? (limit - 1) : (rear - 1);
            return queue[last];

        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    public static void main(String[] args) {

    }
}
