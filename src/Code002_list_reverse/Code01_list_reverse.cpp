#include <iostream>
using namespace std;

typedef struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

/**
 * 反转单链表
 */
ListNode *reverseList(ListNode *head)
{
    ListNode *pre = nullptr;
    ListNode *next = nullptr;

    while (head != nullptr)
    {
        next = head->next; // 保存下一个节点
        head->next = pre;  // 反转当前节点的指针
        pre = head;        // 移动前驱节点到当前节点
        head = next;       // 移动当前节点到下一个节点
    }
    return pre;
}

typedef struct DoubleListNode
{
    int value;
    DoubleListNode *next;
    DoubleListNode *last;
    DoubleListNode(int value) : value(value), last(nullptr), next(nullptr) {}
};

/**
 * 反转双链表
 */
DoubleListNode *reverseDoubleList(DoubleListNode *head)
{
    DoubleListNode *pre = nullptr, *next = nullptr;

    while (head != nullptr)
    {
        next = head->next;
        head->next = pre;
        head->last = next;
        pre = head;
        head = next;
    }
    return pre;
}