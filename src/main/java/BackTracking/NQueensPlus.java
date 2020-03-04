package BackTracking;
/**
 * @author Honghan Zhu
 * @leetcode 52
 * @grade hard
 */
public class NQueensPlus {
    int res = 0;

    public int totalNQueens(int n) {
        int[] queens = new int[n];
        backtrack(queens, 0, n);
        return res;
    }

    private void backtrack(int[] queens, int idx, int n) {
        if (idx == n) {
            res += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean canPlaced = true;
            for (int j = idx - 1; j >= 0; j--) {
                if (Math.abs(j - idx) == Math.abs(queens[j] - i)
                        || i == queens[j]) {
                    canPlaced = false;
                    break;
                }
            }
            if (canPlaced) {
                queens[idx] = i;
                backtrack(queens, idx + 1, n);
            }
        }
    }
}
