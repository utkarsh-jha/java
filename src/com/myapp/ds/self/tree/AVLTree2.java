package com.myapp.ds.self.tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree2 {
    class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.height = 1;

        }
    }

    private Node root;

    private int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int balance(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    public void insert(int key) {
        root = insertRecusrive(root, key);
    }

    public Node clockwiseRotate(Node n) {

        Node nl = n.left;
        Node nlr = nl.right;


        nl.right = n;
        n.left = nlr;

        n.height = max(height(n.left), height(n.right)) + 1;
        nl.height = max(height(nl.left), height(nl.right)) + 1;

        return nl;
    }

    public Node anticlockwiseRotate(Node n) {
        Node nr = n.right;
        Node nrl = nr.left;

        nr.left = n;
        n.right = nrl;

        n.height = max(height(n.left), height(n.right)) + 1;
        nr.height = max(height(nr.left), height(nr.right)) + 1;

        return nr;
    }

    void preorder(Node n) {
        if (n == null) return;
        System.out.print(n.key +" ");
        preorder(n.left);
        preorder(n.right);
    }

    public Node insertRecusrive(Node n, int key) {
        if (n == null) return new Node(key);

        if (n.key < key) {
            n.right = insertRecusrive(n.right, key);
        } else if (n.key > key) {
            n.left = insertRecusrive(n.left, key);
        } else {
            return n;
        }

        n.height = max(height(n.left), height(n.right)) + 1;

        int balance = balance(n);

        //left left
        if (balance > 1 && key < n.left.key) {
            System.out.println(balance);
            return clockwiseRotate(n);
        }

        //right right
        if (balance < -1 && key > n.right.key) {
            return clockwiseRotate(n);
        }

        //left right
        if (balance > 1 && key > n.left.key) {
            n.left = anticlockwiseRotate(n.left);
            return clockwiseRotate(n);
        }

        //right left
        if (balance < -1 && n.right.key > key) {
            n.right = clockwiseRotate(n.right);
            return anticlockwiseRotate(n);
        }

        return n;
    }

    void printBFS() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return;
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.key + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree2 t = new AVLTree2();
        //binary tree insertion
//        t.insert(80);
//        t.insert(40);
//        t.insert(120);
//        t.insert(20);
//        t.insert(60);
//        t.insert(100);
//        t.insert(140);
//        t.insert(10);
//        t.insert(30);
//        t.insert(50);
//        t.insert(70);
//        t.insert(90);
//        t.insert(110);
//        t.insert(130);
//        t.insert(160);
//        t.preorder(t.root);
//        System.out.println();
//        t.printBFS();


        AVLTree2 r = new AVLTree2();
        r.insert(120);
        r.insert(80);
        r.insert(40);
//        r.printBFS();
        r.preorder(r.root);
        System.out.println();

    }

}
