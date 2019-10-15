package Stack;


import java.util.Stack;

/**
 * @author Honghan Zhu
 * @leetcode 20
 * @grade easy
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] strArray = s.toCharArray();
        Stack stack = new Stack();
        for (char c : strArray) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                switch (c) {
                    case '}':
                        if (stack.size() == 0 || (char) stack.pop() != '{') return false;
                        break;
                    case ']':
                        if (stack.size() == 0 || (char) stack.pop() != '[') return false;
                        break;
                    case ')':
                        if (stack.size() == 0 || (char) stack.pop() != '(') return false;
                        break;
                }
            }
        }
        if (0 != stack.size()) {
            return false;
        }
        return true;
    }
}
