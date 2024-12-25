package Code011_BinaryTreeTraversalIteration;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code02_Traversal {
    public class TreeNode2 {
        int val;
        TreeNode2 left;
        TreeNode2 right;

        TreeNode2() {
        }

        TreeNode2(int val) {
            this.val = val;
        }

        TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode2 head) {
        List<Integer> ans = new ArrayList<>();

        if (head == null)
            return null;

        Stack<TreeNode2> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            head = stack.pop();
            ans.add(head.val);
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode2 head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode2> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    ans.add(head.val);
                    head = head.right;
                }
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode2 h) {
        List<Integer> ans = new ArrayList<>();

        if (h != null) {
            Stack<TreeNode2> stack = new Stack<>();
            stack.push(h);
            while (!stack.isEmpty()) {
                TreeNode2 cur = stack.peek();
                if (cur.left != null && h != cur.left && h != cur.right)
                    stack.push(cur.left);
                else if (cur.right != null && h != cur.right)
                    stack.push(cur.right);
                else {
                    ans.add(cur.val);
                    h = stack.pop();
                }
            }
        }
        return ans;
    }
}
