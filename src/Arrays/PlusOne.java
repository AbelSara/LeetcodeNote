package Arrays;


import java.util.Stack;

/**
 * @author: Honghan Zhu
 * @leetcode: 66
 * @grade: easy
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        Stack stack = new Stack();
        boolean plus = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = true == plus ? 1 : 0;
            plus = false;
            temp += digits[i];
            if (temp >= 10) {
                temp = temp % 10;
                plus = true;
            }
            stack.push(temp);
        }
        if (plus) {
            stack.push(1);
        }
        int result[] = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) stack.pop();
        }
        return result;
    }
}
