package com.myapp.ds.self.tree;


import java.util.Arrays;

class Trie {
    class TrieNode {
        private static final int R = 26;
        private TrieNode[] links;
        private boolean isEnd;
        private int id = (int)(Math.random()*100);


        @Override
        public String toString() {
            return " \nTrieNode{" +
                    "\n\tlinks=" + Arrays.toString(links) +
                    "\n\t, isEnd=" + isEnd +
                    "}\n";
        }

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char key) {
            return links[key - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }


        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!t.containsKey(currentChar)) {
                t.put(currentChar, new TrieNode());
            }
            t = t.get(currentChar);
        }
        t.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (t.containsKey(currentChar)) {
                t = t.get(currentChar);
            } else {
                return null;
            }
        }
        return t;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
        t.insert("hell");
//        System.out.println(t);
        System.out.println(t.search("hell"));

    }
}
