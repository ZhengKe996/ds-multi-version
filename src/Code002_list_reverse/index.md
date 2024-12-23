# 反转链表

## 反转单链表

```java
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
```

## 反转双链表
```java
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
```