package Code004_add_two_numbers;

// 测试链接：https://leetcode.cn/problems/add-two-numbers/

public class Code01_add_two_numbers {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 题目要去 先个位 再十位...
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null, cur = null;
        int carry = 0;// 用于记录进位
        for (int sum, val; l1 != null
                || l2 != null; l1 = l1 == null ? null : l1.next, l2 = l2 == null ? null : l2.next) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            val = sum % 10; // 用于记录所新建结点的值
            carry = sum / 10;// 记录进位，用于下一次循环的运算

            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry > 0)
            cur.next = new ListNode(carry);

        return ans;
    }

}
