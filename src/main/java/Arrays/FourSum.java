package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int tmpNum = nums[i];
            List<List<Integer>> tmp = threeSum(nums, i + 1, target - nums[i]);
            tmp.stream().forEach(list -> {
                list.add(tmpNum);
                res.add(list);
            });
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] nums, int s, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = s; i < nums.length - 2; ++i) {
            if (i > s && nums[i] == nums[i - 1]) continue;
            int tmpNum = nums[i];
            List<List<Integer>> tmp = twoSum(nums, i + 1, nums.length - 1, target - nums[i]);
            tmp.stream().forEach(list -> {
                list.add(tmpNum);
                res.add(list);
            });
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int s, int e, int target) {
        List<List<Integer>> res = new ArrayList<>();
        while (s < e) {
            if (nums[s] + nums[e] == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[s++]);
                tmp.add(nums[e--]);
                res.add(tmp);
                while (s < e && nums[s - 1] == nums[s]) ++s;
                while (s < e && nums[e + 1] == nums[e]) --e;
            } else if (target > nums[s] + nums[e]) {
                ++s;
            } else if (target < nums[s] + nums[e]) {
                --e;
            }
        }
        return res;
    }
}
