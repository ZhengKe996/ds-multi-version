#include <iostream>

using namespace std;
// 测试链接：https://leetcode.cn/problems/add-two-numbers/

typedef struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
{
    ListNode *ans = nullptr, *cur = nullptr;
    int carry = 0;

    for (int sum, val; l1 != nullptr || l2 != nullptr; l1 = l1 == nullptr ? nullptr : l1->next, l2 = l2 == nullptr ? nullptr : l2->next)
    {
        sum = (l1 == nullptr ? 0 : l1->val) + (l2 == nullptr ? 0 : l2->val) + carry;
        val = sum % 10;
        carry = sum / 10;
        if (ans == nullptr)
        {
            ans = new ListNode(val);
            cur = ans;
        }
        else
        {
            cur->next = new ListNode(val);
            cur = cur->next;
        }
    }

    if (carry > 0)
        cur->next = new ListNode(carry);
    return ans;
}