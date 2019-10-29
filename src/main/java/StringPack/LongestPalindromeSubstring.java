package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 5
 * @grade medium
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        char[] str = s.toCharArray();
        int start = 0, end = 0;
        for (int i = 0; i < str.length; i++) {
            int len = longestString(str, i, i);
            int temp = 0;
            if (i + 1 < str.length) {
                temp = longestString(str, i, i + 1);
            }
            len = Math.max(len, temp);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return String.valueOf(str, start, end - start + 1);
    }

    private int longestString(char[] str, int start, int end) {
        int len = 0;
        while (start >= 0 && end < str.length && str[start] == str[end]) {
            if (end - start + 1 > len) {
                len = end - start + 1;
            }
            end += 1;
            start -= 1;
        }
        return len;
    }
}
