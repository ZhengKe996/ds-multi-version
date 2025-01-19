package Code017_HeapApplication;

import java.util.ArrayList;
import java.util.PriorityQueue;

// 合并K个有序链表 测试链接：https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6
/**
 * 思路:
 * 1. 使用优先级队列 因为不会去重;
 * 2. 由于数组中存放的是不同的链表的头节点, 于是 将所有的头结点放入优先级队列(自动调整为小根堆)中， 取出队头(值最小的结点)，当新头；
 * 3. 当一个结点出队时，其子结点入队 循环往复 直到队列为空即可返回
 */
public class Code01_MergeKSortedLists {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode h : lists) {
            // 遍历所有的头！
            if (h != null) {
                heap.add(h);
            }
        }

        if (heap.isEmpty()) return null;

        ListNode h = heap.poll();
        ListNode pre = h;
        if (pre.next != null) heap.add(pre.next);

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) heap.add(cur.next);
        }

        return h;
    }
}
