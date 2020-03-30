package BinarySearch;

/**
 * @author Honghan Zhu
 * @leetcode 378
 * @grade medium
 */
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int count = lessThanMediant(matrix, m, n, mid);
            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int lessThanMediant(int[][] matrix, int m, int n, int tar) {
        int res = 0;
        for (int i = 0; i < m && matrix[i][0] <= tar; i++) {
            if (matrix[i][n - 1] <= tar) {
                res += n;
                continue;
            }
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (matrix[i][mid] < tar)
                    l = mid + 1;
                else
                    r = mid;
            }
            while(l < n && matrix[i][l] <= tar)
                l++;
            res += l;
        }
        return res;
    }
}
