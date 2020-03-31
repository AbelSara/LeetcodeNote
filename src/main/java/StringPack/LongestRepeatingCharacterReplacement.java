package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 424
 * @grade medium
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0)
            return 0;
        char[] str = s.toCharArray();
        int l = 0, r = 0, max = 0;
        int[] dict = new int[26];
        while (r < str.length) {
            int idx = s.charAt(r) - 'A';
            dict[idx] += 1;
            max = Math.max(dict[idx], max);
            r++;
            if (r - l > max + k) {
                dict[s.charAt(l) - 'A'] -= 1;
                l += 1;
            }
        }
        return r - l;
    }
}
