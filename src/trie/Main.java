package trie;

/**
 * Author:Honghan Zhu
 * leetcode:720
 * Grade:easy
 */
public class Main {
    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary=new LongestWordInDictionary();
        String[] words=new String[]{"w","wo","wor","worl","world"};
        System.out.println("result is "+longestWordInDictionary.longestWord(words));
    }
}
