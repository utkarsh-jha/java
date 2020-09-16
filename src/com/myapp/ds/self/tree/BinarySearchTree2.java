package com.myapp.ds.self.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree2 {
    class Node {
        int key, dx, dy;
        Node left, right;

        Node(int key, int dx, int dy) {
            this.key = key;
            this.dx = dx;
            this.dy = dy;
            left = right = null;
        }
    }

    Node root;

    public void insert(int key) {
        root = insertRecursive(root, key, 0, 0);
    }

    Node insertRecursive(Node n, int k, int dx, int dy) {
        if (n == null)
            return new Node(k, dx, dy);

        if (k < n.key) {
            n.left = insertRecursive(n.left, k, n.dx + 1, n.dy - 1);
        } else if (k > n.key) {
            n.right = insertRecursive(n.right, k, n.dx + 1, n.dy + 1);
        } else {
            //duplicate insertion not allowed
            return n;
        }
        return n;
    }

    void preorder(Node n) {
        if (n == null) return;
        System.out.print(n.key + "(" + n.dx + "," + n.dy + ")" + " ");
        preorder(n.left);
        preorder(n.right);
    }

    void print() {
        preorder(root);
        System.out.println();
    }

    List<Node> printBFS() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return null;
        List<Node> ret = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            ret.add(n);
            System.out.print(n.key + "(" + n.dx + "," + n.dy + ")" + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        System.out.println();
        return ret;
    }

    void printLeftSide() {
        List<Node> p = printBFS();
        if (p == null) return;
        int cur, prev = -1;
        for (Node n : p) {
            cur = n.dx;
            if (prev != cur) {
                System.out.print(n.key + " ");
            }
            prev = cur;

        }
    }

    void printRightSide() {
        List<Node> p = printBFS();
        if (p == null) return;
        Node element = p.get(0);
        for (int i = 0; i < p.size(); i++) {
            Node n = p.get(i);
            if (n.dx != element.dx) {
                System.out.print(element.key + " ");
            }
            element = n;
            if (i + 1 == p.size()) {
                System.out.println(element.key);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree2 tree = new BinarySearchTree2();
//        tree.insert(8);
//        tree.insert(7);
//        tree.insert(6);
//        tree.insert(5);
//        tree.insert(4);
//        tree.insert(3);
//        tree.insert(2);
//        tree.insert(1);
//        tree.printRightSide();

    }

}
