package Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 74
 * @grade medium
 */
public class SearchTwoDimentionalMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int idx = -1;
        for (int i = 0; i < matrix.length; ++i) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            return false;
        int s = 0, e = matrix[0].length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (matrix[idx][m] == target)
                return true;
            else if (matrix[idx][m] < target)
                s = m + 1;
            else if (matrix[idx][m] > target)
                e = m - 1;
        }
        return false;
    }
}
