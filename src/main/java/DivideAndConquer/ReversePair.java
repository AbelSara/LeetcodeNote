package DivideAndConquer;

/**
 * @author Honghan Zhu
 * @leetcode 493
 * @grade hard
 */
public class ReversePair {
    public int reversePairs(int[] nums) {
        return nums.length == 0 ? 0 : mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] tmp, int s, int e) {
        if (s == e)
            return 0;
        int mid = (s + e) / 2;
        int pairsOfLeft = mergeSort(nums, tmp, s, mid);
        int pairsOfRight = mergeSort(nums, tmp, mid + 1, e);
        int pairs = 0;
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && (long) nums[j] * 2 < nums[i])
                j++;
            pairs += j - mid - 1;
        }
        merge(nums, tmp, s, mid + 1, s, s, mid, e);
        return pairs + pairsOfLeft + pairsOfRight;
    }

    private void merge(int[] nums, int[] tmp, int i, int j, int k, int s, int mid, int e) {
        while (i <= mid && j <= e) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid)
            tmp[k++] = nums[i++];
        while (j <= e)
            tmp[k++] = nums[j++];
        while (s <= e)
            nums[s] = tmp[s++];
    }
}
