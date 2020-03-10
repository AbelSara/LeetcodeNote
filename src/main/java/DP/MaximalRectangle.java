package DP;

import java.util.Stack;

/**
 * @author Honghan Zhu
 * @leetcode 85
 * @grade hard
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i] = matrix[0][i] - '0';
            res = Math.max(res, maximal(dp));
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    dp[j] = dp[j] + 1;
                else
                    dp[j] = 0;
            }
            res = Math.max(res, maximal(dp));
        }
        return res;
    }

    private int maximal(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                ans = Math.max(ans, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return ans;
    }

    public static void main(String[] args) {
        new MaximalRectangle().maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
    }
}
