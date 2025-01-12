package Code009_circular_deque;

import java.util.Deque;
import java.util.LinkedList;

// 测试链接 : https://leetcode.cn/problems/design-circular-deque/
public class Code01_CircularDeque {

    class MyCircularDeque {
        public Deque<Integer> queue = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull())
                return false;
            queue.offerFirst(value);
            size++;
            return true;

        }

        public boolean insertLast(int value) {
            if (isFull())
                return false;
            queue.offerLast(value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty())
                return false;
            size--;
            queue.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty())
                return false;
            size--;
            queue.pollLast();
            return true;

        }

        public int getFront() {
            if (isEmpty())
                return -1;
            else
                return queue.peekFirst();
        }

        public int getRear() {
            if (isEmpty())
                return -1;
            else
                return queue.peekLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    class MyCircularDeque2 {
        public int[] deque;
        public int front, rear, size, limit;

        public MyCircularDeque2(int k) {
            deque = new int[k];
            front = rear = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    front = rear = 0;
                    deque[0] = value;
                } else {
                    front = front == 0 ? (limit - 1) : (front - 1);
                    deque[front] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    front = rear = 0;
                    deque[0] = value;
                } else {
                    rear = rear == limit - 1 ? 0 : (rear + 1);
                    deque[rear] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty())
                return false;
            else {
                size--;
                front = (front == limit - 1) ? 0 : (front + 1);

                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty())
                return false;
            else {
                size--;
                rear = rear == 0 ? (limit - 1) : (rear - 1);
                return true;
            }
        }

        public int getFront() {
            if (isEmpty())
                return -1;
            else
                return deque[front];
        }

        public int getRear() {
            if (isEmpty())
                return -1;
            else
                return deque[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;

        }
    }

}