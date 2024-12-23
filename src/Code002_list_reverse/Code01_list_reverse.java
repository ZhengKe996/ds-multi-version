package Code002_list_reverse;

// 反转单链表测试链接 : https://leetcode.cn/problems/reverse-linked-list/

public class Code01_list_reverse {

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

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static class DoubleListNode {
        public int value;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int value) {
            this.value = value;
        }
    }

    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
