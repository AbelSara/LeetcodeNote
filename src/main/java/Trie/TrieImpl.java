package Trie;

/**
 * @author Honghan Zhu
 * @leetcode 208
 * @grade medium
 */
public class TrieImpl {
    Node head = null;

    /**
     * Initialize your data structure here.
     */
    public TrieImpl() {
        head = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node p = head;
        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            Node curNode = p.nodes[val - 'a'];
            if (curNode == null) {
                curNode = new Node(val);
            }
            p.nodes[val - 'a'] = curNode;
            p = curNode;
        }
        p.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node p = head;
        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            if (p.nodes[val - 'a'] == null)
                return false;
            p = p.nodes[val - 'a'];
        }
        return p.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node p = head;
        for (int i = 0; i < prefix.length(); i++) {
            char val = prefix.charAt(i);
            if (p.nodes[val - 'a'] == null)
                return false;
            p = p.nodes[val - 'a'];
        }
        return !p.isWord;
    }

    class Node {
        Node[] nodes = new Node[26];
        char val = '.';
        boolean isWord = false;

        Node() {
        }

        Node(char val) {
            this.val = val;
        }
    }
}
