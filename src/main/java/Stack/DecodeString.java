package Stack;

import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 394
 * @grade medium
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int l = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                    i += 1;
                int r = i + 1;
                int coef = Integer.valueOf(s.substring(l, r));
                intStack.push(coef);
                continue;
            }
            if (s.charAt(i) != ']') {
                if (intStack.isEmpty())
                    resBuilder.append(s.charAt(i));
                else
                    charStack.push(String.valueOf(s.charAt(i)));
            } else {
                String val = "";
                while (!charStack.peek().equals("["))
                    val = charStack.pop() + val;
                charStack.pop();
                int coef = intStack.pop();
                StringBuilder builder = new StringBuilder();
                while (coef > 0) {
                    builder.append(val);
                    coef -= 1;
                }
                if (!intStack.isEmpty()) {
                    charStack.push(builder.toString());
                } else {
                    resBuilder.append(builder);
                }
            }
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }
}
