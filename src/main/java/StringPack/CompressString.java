package StringPack;

/**
 * @author Honghan Zhu
 * @面试题 01.06
 * @grade easy
 */
public class CompressString {
    public String compressString(String S) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); ) {
            char c = S.charAt(i);
            builder.append(c);
            int sum = 0;
            for (; i < S.length() && S.charAt(i) == c; i++)
                sum += 1;
            builder.append(sum);
        }
        String str = builder.toString();
        return str.length() < S.length() ? str : S;
    }
}
