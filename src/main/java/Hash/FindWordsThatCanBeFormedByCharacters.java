package Hash;

/**
 * @author Honghan Zhu
 * @leetcode 1160
 * @grade easy
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] dict = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            dict[chars.charAt(i) - 'a'] += 1;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int[] curDict = new int[26];
            boolean match = true;
            for (int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';
                curDict[idx] += 1;
                if (curDict[idx] > dict[idx]) {
                    match = false;
                    break;
                }
            }
            if (match)
                res += word.length();
        }
        return res;
    }
}
