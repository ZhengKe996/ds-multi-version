#include <iostream>
#include <vector>
#include <stack>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
public:
    vector<int> preorderTraversal(TreeNode *head)
    {
        vector<int> ans;
        if (head == nullptr)
            return ans;
        stack<TreeNode *> s;
        s.push(head);
        while (!s.empty())
        {
            head = s.top();
            s.pop();
            ans.push_back(head->val);
            if (head->right != nullptr)
                s.push(head->right);
            if (head->left != nullptr)
                s.push(head->left);
        }
        return ans;
    }

    vector<int> inorderTraversal(TreeNode *head)
    {
        vector<int> ans;
        if (head != nullptr)
        {
            stack<TreeNode *> stack;
            while (!stack.empty() || head != nullptr)
            {
                if (head != nullptr)
                {
                    stack.push(head);
                    head = head->left;
                }
                else
                {
                    head = stack.top();
                    stack.pop();
                    ans.push_back(head->val);
                    head = head->right;
                }
            }
        }
        return ans;
    }

    vector<int> postorderTraversal(TreeNode *h)
    {
        vector<int> ans;
        if (h != nullptr)
        {
            stack<TreeNode *> s;
            s.push(h);

            while (!s.empty())
            {
                TreeNode *cur = s.top();
                if (cur->left != nullptr && h != cur->left && h != cur->right)
                    s.push(cur->left);
                else if (cur->right != nullptr && h != cur->right)
                    s.push(cur->right);
                else
                {
                    ans.push_back(cur->val);
                    h = s.top();
                    s.pop();
                }
            }
        }
        return ans;
    }
};