package Arrays;

/**
 * @Author Honghan Zhu
 * @leetcode 59
 * @grade medium
 */
public class SpiralMatrixPlus {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1;
        int endIdx = n * n;
        int rs = 0, re = n - 1, cs = 0, ce = n - 1;
        while (index <= endIdx) {
            for (int i = cs; i <= ce && index <= endIdx; i++) {
                res[rs][i] = index++;
            }
            rs++;
            for (int i = rs; i <= re && index <= endIdx; i++) {
                res[i][ce] = index++;
            }
            ce--;
            for (int i = ce; i >= cs && index <= endIdx; i--) {
                res[re][i] = index++;
            }
            re--;
            for (int i = re; i >= rs && index <= endIdx; i--) {
                res[i][cs] = index++;
            }
            cs++;
        }
        return res;
    }
}

/*
 1 2 3
 8 0 4
 9 6 5
 */
