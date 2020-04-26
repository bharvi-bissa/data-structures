package com.ds.tree;

public interface TreeInterface<T> {

    void inorderTraversalRecursive(TreeNode<T> root);

    void preOrderTraversalRecursive(TreeNode<T> root);

    void postOrderTraversalRecursive(TreeNode<T> root);

    void preOrderTraversalIterative(TreeNode<T> root);

    void inOrderTraversalIterative(TreeNode<T> root);

    void postOrderTraversalIterative(TreeNode<T> root);
}
