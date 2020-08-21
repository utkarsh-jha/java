package com.myapp.ds.self;

import com.sun.javafx.scene.traversal.TraversalEngine;

import javax.xml.soap.Node;
import java.util.Stack;


public class Tree {
    class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }

        public TreeNode() {
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + value +
                    ", leftNode=" + left +
                    ", rightNode=" + right +
                    '}';
        }
    }

    private TreeNode root;


    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private void add(int value) {
        root = addRecursive(root, value);
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    public void preorder(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(TreeNode node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public void print_inorder_without_recursion() {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.value + " ");
            curr = curr.right;

        }
    }

    public void print_postorder_without_recursion() {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>(), o = new Stack<>();
//        ;
        s.push(root);
        while (!s.empty()) {
            TreeNode c = s.pop();
            o.push(c);

            if(c.left != null){
                s.push(c.left);
            }

            if(c.right != null){
                s.push(c.right);
            }
        }

        while (!o.empty()) System.out.print( o.pop().value+ " ");
    }

    public void print_preorder_without_recursion() {
        if (root == null) return;
        TreeNode c = root;
        Stack<TreeNode> s = new Stack<>();
        while (c != null || s.size() > 0) {
            while (c != null) {
                System.out.print(c.value + " ");
                s.push(c);
                c = c.left;
            }
            c = s.pop();
            c = c.right;
        }
    }


    public TreeNode getRoot() {
        return root;
    }

    enum TraversalMode {
        INORDER,
        INORDER_WO_R,
        PREORDER,
        PREORDER_WO_R,
        POSTORDER,
        POSTORDER_WO_R
    }

    public void print(TraversalMode mode) {
        switch (mode) {
            case INORDER:
                System.out.println("INORDER");
                inOrderTraversal(root);
                break;
            case POSTORDER:
                System.out.println("POSTORDER");
                postorder(root);
                break;
            case PREORDER:
                System.out.println("PREORDER");
                preorder(root);
                break;
            case INORDER_WO_R:
                System.out.println("INORDER_WO_R");
                print_inorder_without_recursion();
                break;
            case POSTORDER_WO_R:
                System.out.println("POSTORDER_WO_R");
                print_postorder_without_recursion();
                break;
            case PREORDER_WO_R:
                System.out.println("PREORDER_WO_R");
                print_preorder_without_recursion();
                break;
            default:
                throw new IllegalArgumentException("invalid");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.add(20);
        t.add(4);
        t.add(21);
        t.add(8);
        t.add(5);
        t.add(10);
        t.print(TraversalMode.INORDER);
        t.print(TraversalMode.INORDER_WO_R);
        t.print(TraversalMode.PREORDER);
        t.print(TraversalMode.PREORDER_WO_R);
        t.print(TraversalMode.POSTORDER);
        t.print(TraversalMode.POSTORDER_WO_R);


    }

}
