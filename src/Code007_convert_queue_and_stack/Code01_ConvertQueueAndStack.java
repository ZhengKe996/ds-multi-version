package Code007_convert_queue_and_stack;

import java.util.Stack;

// 测试链接 : https://leetcode.cn/problems/implement-queue-using-stacks/

public class Code01_ConvertQueueAndStack {
    class MyQueue {

        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        private void in2out() {
            if (out.empty()) {
                while (!in.empty())
                    out.push(in.pop());
            }
        }

        public void push(int x) {
            in.push(x);
            in2out();
        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }
    }
}
