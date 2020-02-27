package Stack;

import java.util.Stack;

/**
 * @author Honghan Zhu
 * @leetcode 42
 * @grade hard
 */
public class TrappingRainWater {
    /**
     * @description my method of stack
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int max = 0;
        int sum = 0;
        int minus = 0;
        int dis = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            if(height[i] >= max && !stack.isEmpty()){
                while(stack.peek() != max){
                    minus += stack.pop();
                    dis += 1;
                }
                stack.pop();
                sum += dis * max - minus;
                minus = 0;
                dis = 0;
                stack.clear();
            }
            max = Math.max(max, height[i]);
            stack.push(height[i]);
        }
        max = 0;
        boolean trapped = false;
        while(!stack.isEmpty()){
            int h = stack.pop();
            if(h < max){
                minus += h;
                dis += 1;
                trapped = true;
            }else if(max != 0 && trapped){
                sum += dis * max - minus;
                dis = 0;
                minus = 0;
                trapped = false;
            }
            max = Math.max(h, max);
        }
        return sum;
    }

    /**
     * @description use dynamic process method
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int[] heightOfLeft = new int[height.length];
        int[] heightOfRight = new int[height.length];
        for(int i = 1; i < height.length; i++)
            heightOfLeft[i] = Math.max(heightOfLeft[i - 1], height[i - 1]);
        for(int i = height.length - 2; i >= 0; i--)
            heightOfRight[i] = Math.max(heightOfRight[i + 1], height[i + 1]);
        int res = 0;
        for(int i = 0; i < height.length; i++){
            int minOfHeight = Math.min(heightOfLeft[i], heightOfRight[i]);
            if(minOfHeight > height[i])
                res += minOfHeight - height[i];
        }
        return res;
    }
}
