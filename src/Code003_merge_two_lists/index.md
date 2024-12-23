# 合并两个有序链表

```java
public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null)
        return head1 == null ? head2 : head1; // 当其中一个为空链表时，返回另一个当新头

    ListNode head = head1.val <= head2.val ? head1 : head2; // 取两个链表中最小的那个当做新头

    ListNode cur1 = head.next;
    ListNode cur2 = head == head1 ? head2 : head1;
    ListNode pre = head;

    while (cur1 != null && cur2 != null) {
        if (cur1.val <= cur2.val) {
            pre.next = cur1;
            cur1 = cur1.next;
        } else {
            pre.next = cur2;
            cur2 = cur2.next;
        }
        pre = pre.next;
    }
    pre.next = cur1 != null ? cur1 : cur2; // 边界条件，当其中一个链表为空时，将剩下的接在后面

    return head;
}
```
