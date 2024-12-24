package Code008_MinStack;

import java.util.Stack;

// 测试链接 : https://leetcode.cn/problems/min-stack/

public class Code01_GetMinStack {
    class MinStack1 {
        public Stack<Integer> data;
        public Stack<Integer> min;

        public MinStack1() {
            data = new Stack<Integer>();
            min = new Stack<Integer>();
        }

        public void push(int val) {
            data.push(val); // 两个栈同时操作，保证长度一致
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            } else {
                min.push(min.peek());
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    class MinStack2 {
        public final int MAXN = 8001;
        public int data[];
        public int min[];
        public int size;

        public MinStack2() {
            data = new int[MAXN];
            min = new int[MAXN];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || val <= min[size - 1])
                min[size] = val;
            else
                min[size] = min[size - 1];
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size-1];
        }

        public int getMin() {
            return min[size-1];
        }
    }
}
