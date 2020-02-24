package DP;

import java.util.Stack;

/**
 * @author Honghan Zhu
 * @leetcode 32
 * @grade hard
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] parentheses = s.toCharArray();
        int[] dp = new int[s.length()];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '(')
                stack.push(i);
            else if (!stack.isEmpty()) {
                int pre = stack.pop();
                dp[i] = i - pre + 1 + (pre - 1 >= 0 ? dp[pre - 1] : 0);
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
