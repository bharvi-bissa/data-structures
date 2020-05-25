package com.ds.tree;

import java.util.Stack;

public class Tree<T> implements TreeInterface<T> {



    public TreeNode<Integer> createBinaryTree(){
        /*
         *              4
         *            /  \
         *           3    9
         *          / \  / \
         *         7  1 22 15
         *        /          \
         *       25          30
         */
        TreeNode<Integer> seventhNode = new TreeNode<>(30);
        TreeNode<Integer> eighthNode = new TreeNode<>(25);

        TreeNode<Integer> secondNode = new TreeNode<>(7,eighthNode,null);
        TreeNode<Integer> thirdNode = new TreeNode<>(1);
        TreeNode<Integer> firstNode = new TreeNode<>(3,secondNode,thirdNode);

        TreeNode<Integer> fifthNode = new TreeNode<>(22);
        TreeNode<Integer> sixthNode = new TreeNode<>(15,null,seventhNode);
        TreeNode<Integer> fourthNode = new TreeNode<>(9,fifthNode,sixthNode);

        TreeNode<Integer> root = new TreeNode<>(4,firstNode,fourthNode);

        return root;
    }

    @Override
    public void inorderTraversalRecursive(TreeNode<T> root) {
        //left -> root -> right
        if(root == null){
            return;
        }
        inorderTraversalRecursive(root.left);
        System.out.print(root.data+" ");
        inorderTraversalRecursive(root.right);
    }

    @Override
    public void preOrderTraversalRecursive(TreeNode<T> root) {
        //root -> left -> right
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);

    }

    @Override
    public void postOrderTraversalRecursive(TreeNode<T> root) {

    }

    /*
    * 1.Add root node in stack.
    * 2.while stack is not empty
    *   2.1 pop node & print data.
    *   2.2 if node has right push it in stack.( we push right first in stack because we want to print left first & then right)
    *   2.3 if node has left push it in stack.
    *
    * */
    @Override
    public void preOrderTraversalIterative(TreeNode<T> root) {
        if(root == null){
            return;
        }
        Stack<TreeNode<T>> callStack = new Stack<>();
        callStack.push(root);

        while(!callStack.isEmpty()){
            TreeNode<T> tempNode = callStack.pop();
            System.out.print(tempNode.data + " ");
            if(tempNode.right !=null){
                callStack.push(tempNode.right);
            }
            if(tempNode.left!=null){
                callStack.push(tempNode.left);
            }
        }
    }

    @Override
    public void inOrderTraversalIterative(TreeNode<T> root) {

    }

    @Override
    public void postOrderTraversalIterative(TreeNode<T> root) {

    }
}
