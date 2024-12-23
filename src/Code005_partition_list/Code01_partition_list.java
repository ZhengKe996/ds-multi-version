package Code005_partition_list;

// 测试链接 : https://leetcode.cn/problems/partition-list/

public class Code01_partition_list {
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

    public ListNode partition(ListNode head, int x) {

        ListNode leftHead = null, leftTail = null;// <=x的区域
        ListNode rightHead = null, rightTail = null;// >=x的区域
        ListNode next = null;
        while (head != null) {
            next = head.next; // 保留现场
            head.next = null;

            if (head.val < x) {
                if (leftHead == null)
                    leftHead = head;
                else
                    leftTail.next = head;
                leftTail = head;
            } else {
                if (rightHead == null)
                    rightHead = head;
                else
                    rightTail.next = head;
                rightTail = head;
            }
            head = next;
        }
        // <=x的区域为空的情况
        if (leftHead == null)
            return rightHead;

        // <=x的区域不为空的情况
        leftTail.next = rightHead;
        return leftHead;
    }
}
