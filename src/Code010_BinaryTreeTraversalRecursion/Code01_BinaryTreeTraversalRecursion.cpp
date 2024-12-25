#include <iostream>
using namespace std;
struct TreeNode
{
    int val;
    struct TreeNode *left, *right;
    TreeNode(int v) : val(v), left(nullptr), right(nullptr) {}
};

void preOrder(TreeNode *node)
{
    if (node == nullptr)
        return;

    cout << node->val << " ";
    preOrder(node->left);
    preOrder(node->right);
}

void inOrder(TreeNode *node)
{
    if (node == nullptr)
        return;

    inOrder(node->left);
    cout << node->val << " ";
    inOrder(node->right);
}

void postOrder(TreeNode *node)
{
    if (node == nullptr)
        return;

    postOrder(node->left);
    cout << node->val << " ";
    postOrder(node->right);
}

int main()
{
    TreeNode *head = new TreeNode(1);

    head->left = new TreeNode(2);
    head->right = new TreeNode(3);
    head->left->left = new TreeNode(4);
    head->left->right = new TreeNode(5);
    head->right->left = new TreeNode(6);
    head->right->right = new TreeNode(7);

    preOrder(head);
    cout << endl;
    cout << "先序遍历递归版" << endl;

    inOrder(head);
    cout << endl;
    cout << "中序遍历递归版" << endl;

    postOrder(head);
    cout << endl;
    cout << "后序遍历递归版" << endl;

    return 0;
}