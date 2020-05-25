package com.ds.tree;

public class TreeRunner {
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode<Integer> root = tree.createBinaryTree();
        //tree.preOrderTraversalRecursive(root);
        tree.inorderTraversalRecursive(root);
        System.out.println();
        //tree.preOrderTraversalIterative(root);
    }


}
