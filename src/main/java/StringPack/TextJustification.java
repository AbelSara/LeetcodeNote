package StringPack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 68
 * @grade hard
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int start = 0, len = 0;
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if (len + cur.length() > maxWidth) {
                StringBuilder builder = new StringBuilder();
                int spaces = maxWidth - len + i - start;
                if (i == start + 1) {
                    builder.append(words[start++]);
                    for (int j = 0; j < spaces; j++)
                        builder.append(' ');
                } else {
                    int eachSpaces = spaces / (i - start - 1);
                    int remainSpaces = spaces % (i - start - 1);
                    while (start < i) {
                        builder.append(words[start++]);
                        for (int j = 0; start != i && j < eachSpaces; j++)
                            builder.append(' ');
                        if (remainSpaces > 0) {
                            builder.append(' ');
                            remainSpaces -= 1;
                        }
                    }
                }
                res.add(builder.toString());
                len = 0;
            }
            len += cur.length() + 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            builder.append(words[i]);
            if (i < words.length - 1)
                builder.append(' ');
        }
        len = maxWidth - builder.length();
        for (int i = 0; i < len; i++)
            builder.append(' ');
        res.add(builder.toString());
        return res;
    }
}
