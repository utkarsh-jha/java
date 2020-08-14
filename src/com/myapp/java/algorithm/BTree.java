package com.myapp.java.algorithm;

/*
Since it is a M-Way B-tree so M is reuired

Rules 
    - all the leaf node should be at the same level
    - root node if not leaf node must contain 2 children
    - every node can contain m children (maximum)
    - every internal node can have ceil(m/2) (minimu) 
    - non leaf with k children has k-1 keys
 */
public class BTree {

    public static final int M = 5;

    private Node tree = new Node();

    public void insert(int value) {
        if (!hasInserted(tree, value)) {
            insert(tree.getNodeRefs(), value)
        }
    }

    private boolean hasInserted(Node tree, int value) {
        int i = 0;
        while (i < 5) {
            if (tree.getValues()[i] == null) {
                tree.getValues()[i] = value;
                return true;
            }
            i++;
        }
        return false;
    }

    class Node {

        Integer values[] = new Integer[4];
        Node nodeRefs[] = new Node[5];

        public Integer[] getValues() {
            return values;
        }

        public void setValues(Integer[] values) {
            this.values = values;
        }

        public Node[] getNodeRefs() {
            return nodeRefs;
        }

        public void setNodeRefs(Node[] nodeRefs) {
            this.nodeRefs = nodeRefs;
        }

        @Override
        public String toString() {
            return "Node{" + "values=" + values + ", nodeRefs=" + nodeRefs + '}';
        }
    }
}
