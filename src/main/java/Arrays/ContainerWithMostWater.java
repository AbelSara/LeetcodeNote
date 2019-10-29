package Arrays;

/**
 * @author Honghan
 * @leetcode 11
 * @grade medium
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0, j = height.length - 1; j > i; ) {
            int base = j - i;
            int shortSide = height[i] < height[j] ? height[i] : height[j];
            if (base * shortSide > result) {
                result = base * shortSide;
            }
            if (height[i] < height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return result;
    }
}
