package Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 73
 * @grade medium
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int r = 0; r < m; r++) {
                        if (matrix[r][j] != 0)
                            matrix[r][j] = Integer.MAX_VALUE;
                    }
                    for (int c = 0; c < n; c++) {
                        if (matrix[i][c] != 0)
                            matrix[i][c] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = 0;
            }
        }
    }
}
