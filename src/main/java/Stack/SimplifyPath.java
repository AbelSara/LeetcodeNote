package Stack;

import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 71
 * @grade medium
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] elements = path.split("/");
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String ele : elements) {
            if (ele.equals(""))
                continue;
            if (stack.isEmpty() && !ele.equals("..") && !ele.equals(".")) {
                stack.push(ele);
                continue;
            }
            switch (ele) {
                case "..":
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                case ".":
                    break;
                default:
                    stack.push(ele);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            String str = stack.pop();
            builder.insert(0, str);
            builder.insert(0, '/');
        }
        if (builder.length() == 0)
            builder.append('/');
        return builder.toString();
    }
}
