package Code011_BinaryTreeTraversalIteration;

import java.util.Stack;
// 先序遍历测试链接 : https://leetcode.cn/problems/binary-tree-preorder-traversal/
// 中序遍历测试链接 : https://leetcode.cn/problems/binary-tree-inorder-traversal/
// 后序遍历测试链接 : https://leetcode.cn/problems/binary-tree-postorder-traversal/

public class Code01_BinaryTreeTraversalIteration {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    // 非递归实现前序
    public static void preOrder(TreeNode head) {
        if (head == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            head = stack.pop();
            System.out.print(head.val + " ");
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
        System.out.println();
    }

    public static void inOrder(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    public static void posOrderTwoStacks(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val + " ");
            }
            System.out.println();
        }
    }

    public static void posOrderOneStack(TreeNode h) {
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right)
                    stack.push(cur.left);
                else if (cur.right != null && h != cur.right)
                    stack.push(cur.right);
                else {
                    System.out.print(cur.val + " ");
                    h = stack.pop();
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        preOrder(head);
        System.out.println("先序遍历非递归版");
        inOrder(head);
        System.out.println("中序遍历非递归版");
        posOrderTwoStacks(head);
        System.out.println("后序遍历非递归版 - 2个栈实现");
        posOrderOneStack(head);
        System.out.println("后序遍历非递归版 - 1个栈实现");
    }
}
