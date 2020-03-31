package Sort;

/**
 * @author Honghan Zhu
 * @leetcode 912
 * @grade medium
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r, int[] tmp) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid, tmp);
        mergeSort(nums, mid + 1, r, tmp);
        merge(nums, l, mid, r, tmp);
    }

    private void merge(int[] nums, int l, int mid, int r, int[] tmp) {
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j])
                tmp[k++] = nums[i++];
            else
                tmp[k++] = nums[j++];
        }
        while (i <= mid)
            tmp[k++] = nums[i++];
        while (j <= r)
            tmp[k++] = nums[j++];
        for (i = l; i <= r; i++)
            nums[i] = tmp[i];
    }
}
