package com.myapp.ds.self.tree;

import java.lang.reflect.Array;
import java.util.*;

public class Node {
    int key, dx;
    Node left, right;

    Node(int key, int dx) {
        this.key = key;
        this.dx = dx;
    }


    List<Node> printBFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return null;
        List<Node> ret = new ArrayList<>();
        q.add(root);
        System.out.println("BFS ");
        while (!q.isEmpty()) {
            Node n = q.remove();
            ret.add(n);
            System.out.print(n.key + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        System.out.println();
        return ret;
    }

    void printLeftSide(Node root) {
        List<Node> p = printBFS(root);
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

    void printRightSide(Node root) {
        List<Node> p = printBFS(root);
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

    void printPreorder(Node n) {
        if (n == null) return;
        System.out.print(n.key + " ");
        printPreorder(n.left);
        printPreorder(n.right);
    }

    void printDFS(Node root, List<Node> n, int wd) {
        if (root == null) return;
        System.out.print(root.key + "(" + wd + ")" + " ");
        n.add(root);
        printDFS(root.left, n, wd - 1);
        printDFS(root.right, n, wd + 1);
    }

    void preorder(Node root) {
        List<Node> n = new ArrayList<>();
        printDFS(root, n, 0);
        System.out.println();
        for (Node o : n) {
            System.out.print(o.key + " ");
        }
    }
//        System.out.println();
//        for(Node n: e){
//            System.out.print(n.key + " ");
//        }


    public static void main(String[] args) {
        Node root = new Node(1, 0);
        root.left = new Node(2, 1);
        root.right = new Node(3, 1);
        root.left.left = new Node(4, 2);
        root.left.right = new Node(5, 2);
        root.right.left = new Node(6, 2);
        root.right.right = new Node(7, 2);
//        System.out.println(root.key);
//        System.out.println(root.left.left.key);
//        System.out.println(root.left.right.key);

//        root.left = new Node(2, 1);
//        root.left = new Node(3, 1);
//        root.left.right = new Node(4, 1);
//        root.left.right.right = new Node(5, 1);
//        root.left.right.right.right = new Node(6, 1);
//        root.printPreorder(root);
//        root.printBFS(root);
//        root.printLeftSide(root);
//        System.out.println();
//        root.printRightSide(root);

    }
}
