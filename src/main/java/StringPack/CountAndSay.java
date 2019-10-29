package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 38
 * @grade easy
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = count(result);
        }
        return result;
    }

    private String count(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int num = 1;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                num++;
            } else {
                stringBuilder.append(num).append(c);
                num = 1;
                c = str.charAt(i);
            }
        }
        stringBuilder.append(num).append(c);
        return stringBuilder.toString();
    }
}
