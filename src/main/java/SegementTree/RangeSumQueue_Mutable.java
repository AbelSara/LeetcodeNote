package SegementTree;

/**
 * @author Honghan Zhu
 * @leetcode 307
 * @grade medium
 */
public class RangeSumQueue_Mutable {
    int[] tree;
    int n;

    public RangeSumQueue_Mutable(int[] nums) {
        n = nums.length;
        tree = new int[n * 2];
        for (int i = n, j = 0; i < n * 2; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        int pos = i + n;
        tree[pos] = val;
        while (pos > 0) {
            int l = pos, r = pos;
            if (pos % 2 == 0)
                r++;
            else
                l--;
            tree[pos / 2] = tree[l] + tree[r];
            pos /= 2;
        }
    }

    public int sumRange(int i, int j) {
        int l = i + n;
        int r = j + n;
        int res = 0;
        while (l <= r) {
            //将l和r变成二叉树的左右孩子
            //l % 2 == 1保证最终在根节点可以得到
            if (l % 2 == 1) {
                res += tree[l];
                l++;
            }
            if (r % 2 == 0) {
                res += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return res;
    }
}
