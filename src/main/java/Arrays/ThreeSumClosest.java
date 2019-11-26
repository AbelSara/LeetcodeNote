package Arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int dis = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int tmp = nums[i] + twoSumClosest(nums, i + 1, nums.length - 1, target - nums[i]);
            int tmpDis = Math.abs(target - tmp);
            if (tmpDis < dis) {
                result = tmp;
                dis = tmpDis;
            }
        }
        return result;
    }

    private int twoSumClosest(int[] nums, int s, int e, int target) {
        int dis = Integer.MAX_VALUE;
        int res = 0;
        while (s < e) {
            int temp = nums[s] + nums[e];
            if (temp > target) e--;
            else s++;
            int tmpDis = Math.abs(temp - target);
            if (tmpDis < dis) {
                dis = tmpDis;
                res = temp;
            }
        }
        return res;
    }
}
