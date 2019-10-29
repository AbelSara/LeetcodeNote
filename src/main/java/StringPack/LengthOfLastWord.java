package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 58
 * @grade easy
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        String[] strArr = s.split(" ");
        int result = 0;
        for (String str : strArr) {
            if (str.length() > result) {
                result = str.length();
            }
        }
        return result;
    }
}
