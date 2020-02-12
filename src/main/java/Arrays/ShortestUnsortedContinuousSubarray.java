package Arrays;

import java.util.Stack;

/**
 * @Author Honghan Zhu
 * @leetcode 581
 * @grade easy
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -1;
        int n = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[n]) {
                while (i + 1 < nums.length && nums[i + 1] == nums[i])
                    i += 1;
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    int idx = stack.pop();
                    if (start == -1)
                        start = idx;
                    else
                        start = start <= idx ? start : idx;
                }
                end = i;
            } else if (nums[i] > nums[n]) {
                n = i;
                stack.push(n);
            }
        }
        if (start == -1) return 0;
        return end - start + 1;
    }
}
