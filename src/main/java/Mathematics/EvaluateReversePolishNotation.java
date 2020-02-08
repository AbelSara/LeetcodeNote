package Mathematics;

import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 150
 * @grade medium
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        //如果使用int会有拆箱装箱时间
        Integer v1, v2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 + v1);
                    break;
                case "-":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 - v1);
                    break;
                case "*":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 * v1);
                    break;
                case "/":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 / v1);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}
