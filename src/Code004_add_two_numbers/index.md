# 两数之和（考察链表的应用）

`本题给的单链表头结点即为个位 next为十位以此类推`

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = null, cur = null;
    int carry = 0;// 用于记录进位信息
    for (int sum, val; // 函数变量
        l1 != null|| l2 != null; // 循环条件
        l1 = l1 == null ? null : l1.next, l2 = l2 == null ? null : l2.next // 步长
    ) {
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
    
    if (carry > 0) cur.next = new ListNode(carry); // 跳出循环后，如果有进位需要拼回去

    return ans;
}
```
