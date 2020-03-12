package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Honghan Zhu
 * @leetcode 212
 * @grade hard
 */
public class WordSearchPlus {
    public static void main(String[] args) {
        new WordSearchPlus().findWords(new char[][]{{'a', 'a'}}, new String[]{"aaa"});

    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, new boolean[board.length][board[0].length],
                        trie.head, i, j, set);
            }
        }
        List<String> resList = new ArrayList<>(set);
        return resList;
    }

    private void backtrack(char[][] board, boolean[][] visited,
                           TrieNode curNode, int i, int j, Set<String> set) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
            return;
        int next = board[i][j] - 'a';
        if (curNode.childs[next] == null)
            return;
        else if (curNode.childs[next].isWord) {
            set.add(curNode.childs[next].val);
        }
        visited[i][j] = true;
        backtrack(board, visited, curNode.childs[next], i - 1, j, set);
        backtrack(board, visited, curNode.childs[next], i + 1, j, set);
        backtrack(board, visited, curNode.childs[next], i, j - 1, set);
        backtrack(board, visited, curNode.childs[next], i, j + 1, set);
        visited[i][j] = false;
    }

    class Trie {
        TrieNode head;

        Trie() {
            head = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = head;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 'a';
                if (p.childs[next] == null)
                    p.childs[next] = new TrieNode();
                p = p.childs[next];
            }
            p.val = word;
            p.isWord = true;
        }

    }

    class TrieNode {
        TrieNode[] childs;
        boolean isWord;
        String val;

        TrieNode() {
            childs = new TrieNode[26];
            isWord = false;
        }
    }
}


