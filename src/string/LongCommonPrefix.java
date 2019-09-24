package string;

import mathematics.Palindrome;

/**
 * Created by zhh on 2019/9/22.
 */
public class LongCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            boolean sameCharacter = true;
            stringBuilder.append(temp);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || temp != strs[j].charAt(i)) {
                    sameCharacter = false;
                    break;
                }
            }
            if (!sameCharacter) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            }
        }
        return stringBuilder.toString();
    }
}
