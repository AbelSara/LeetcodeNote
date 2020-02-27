package Stack;

import java.util.Stack;

/**
 * @author Honghan Zhu
 * @leetcode 42
 * @grade hard
 */
public class TrappingRainWater {
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
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        new TrappingRainWater().trap(new int[]{9,8,9,5,8,8,8,0,4});
    }
}
