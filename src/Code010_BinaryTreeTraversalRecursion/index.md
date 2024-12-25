# 二叉树的递归遍历

```java
public static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v) {
        val = v;
    }
}

public static void preOrder(TreeNode node) {
    if (node == null)
        return;

    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
}

public static void inOrder(TreeNode node) {
    if (node == null)
        return;

    inOrder(node.left);
    System.out.print(node.val + " ");
    inOrder(node.right);
}

public static void postOrder(TreeNode node) {
    if (node == null)
        return;

    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.val + " ");
}

```