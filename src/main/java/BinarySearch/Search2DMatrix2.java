package BinarySearch;

/**
 * @author Honghan Zhu
 * @leetcode 240
 * @grade medium
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int srow = matrix.length - 1;
        int scol = 0;
        int erow = 0;
        int ecol = matrix[0].length - 1;
        while (srow >= erow && scol <= ecol) {
            if (matrix[srow][scol] == target)
                return true;
            else if (matrix[srow][scol] < target)
                scol += 1;
            else
                srow -= 1;
        }
        return false;
    }
}
