package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 999
 * @grade easy
 */
public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int len = 8;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 'R') {
                    res = capturePawns(board, len, i, j);
                    break;
                }
            }
        }
        return res;
    }

    private int capturePawns(char[][] board, int len, int row, int col) {
        int res = 0;
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'B')
                break;
            else if (board[i][col] == 'p') {
                res += 1;
                break;
            }
        }
        for (int i = row; i < len; i++) {
            if (board[i][col] == 'B')
                break;
            else if (board[i][col] == 'p') {
                res += 1;
                break;
            }
        }
        for (int j = col; j >= 0; j--) {
            if (board[row][j] == 'B')
                break;
            else if (board[row][j] == 'p') {
                res += 1;
                break;
            }
        }
        for (int j = col; j < len; j++) {
            if (board[row][j] == 'B')
                break;
            else if (board[row][j] == 'p') {
                res += 1;
                break;
            }
        }
        return res;
    }
}
