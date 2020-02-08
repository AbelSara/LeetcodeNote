package StringPack;

/**
 * @Author Honghan Zhu
 * @leetcode 151
 * @grade medium
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.equals("")) {
                continue;
            }
            if (builder.length() == 0)
                builder.append(word);
            else
                builder.append(" ").append(word);
        }
        return builder.toString();
    }
}
