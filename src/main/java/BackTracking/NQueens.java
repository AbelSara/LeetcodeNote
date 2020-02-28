package BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 51
 * @grade hard
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++)
            Arrays.fill(matrix[i], '.');
        backtrack(res, matrix, 0, n);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] curMatrix, int idx, int n) {
        if (idx == n) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < curMatrix.length; i++)
                list.add(String.valueOf(curMatrix[i]));
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean canQueue = true;
            for (int j = 0; j < idx; j++) {
                for (int k = 0; k < n; k++) {
                    if (curMatrix[j][k] == 'Q'
                            && (k == i || (Math.abs(k - i) == Math.abs(idx - j)))) {
                        canQueue = false;
                        break;
                    }
                }
            }
            if (canQueue) {
                curMatrix[idx][i] = 'Q';
                backtrack(res, curMatrix, idx + 1, n);
                curMatrix[idx][i] = '.';
            }
        }
    }
}
