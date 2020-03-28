package Trie;

import java.util.LinkedList;

/**
 * @author Honghan Zhu
 * @leetcode 820
 * @grade medium
 */
public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        SETrie trie = new SETrie();
        for (String word : words)
            trie.insert(word);
        int ans = trie.getLength();
        return ans;
    }

    class SETrie {
        SENode head;

        SETrie() {
            head = new SENode();
        }

        boolean isEmpty() {
            return head.charList.isEmpty();
        }

        void insert(String word) {
            SENode p = head;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (p.childs[c - 'a'] == null) {
                    p.childs[c - 'a'] = new SENode();
                    p.charList.addLast(c);
                }
                p = p.childs[c - 'a'];
            }
            p.isWord = true;
        }

        int getLength() {
            SENode p = head;
            int len = 0;
            while (!p.charList.isEmpty()) {
                char next = p.charList.removeFirst();
                len += getSublen(p.childs[next - 'a'], 1);
            }
            return len;
        }

        int getSublen(SENode p, int height) {
            if (p.charList.isEmpty())
                return height + 1;
            int len = 0;
            while (!p.charList.isEmpty()) {
                char next = p.charList.removeFirst();
                len += getSublen(p.childs[next - 'a'], height + 1);
            }
            return len;
        }
    }

    class SENode {
        boolean isWord;
        SENode[] childs;
        LinkedList<Character> charList;

        SENode() {
            isWord = false;
            childs = new SENode[26];
            charList = new LinkedList<>();
        }
    }
}
