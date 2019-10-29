package Trie;


/**
 * @author Honghan Zhu
 * @leetcode 720
 * @grade easy
 */
public class LongestWordInDictionary {
    String longestWord = "";
    int longestLength = 0;

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            if (trie.isBuild(word)) {
                if (word.length() > longestLength) {
                    longestWord = word;
                    longestLength = word.length();
                } else if (word.length() == longestLength) {
                    longestWord = word.compareTo(longestWord) < 0 ? word : longestWord;
                }
            }
        }
        return longestWord;

    }
}

class TrieNode {
    char data;
    TrieNode[] next = new TrieNode[26];
    boolean isWord;

    TrieNode(char data) {
        this.data = data;
        this.isWord = false;
    }
}

class Trie {
    TrieNode root = new TrieNode('/');

    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode p = root;
        for (char c : wordArray) {
            if (null == p.next[c - 'a']) {
                p.next[c - 'a'] = new TrieNode(c);
            }
            p = p.next[c - 'a'];
        }
        p.isWord = true;
    }

    public boolean isBuild(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode p = root;
        for (char c : wordArray) {
            if (false == p.next[c - 'a'].isWord) {
                return false;
            }
            p = p.next[c - 'a'];
        }
        return true;
    }
}
