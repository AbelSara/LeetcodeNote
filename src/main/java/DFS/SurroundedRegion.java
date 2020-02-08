package DFS;

/**
 * @Author Honghan Zhu
 * @leetcode 130
 * @grade medium
 */
public class SurroundedRegion {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        mark(board, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (board[i][j]) {
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    case '.':
                        board[i][j] = 'O';
                        break;
                }

            }
        }
    }

    private void mark(char[][] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m - 1, i, m, n);
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n ||
                board[i][j] == 'X' || board[i][j] == '.')
            return;
        board[i][j] = '.';
        dfs(board, i - 1, j, m, n);
        dfs(board, i + 1, j, m, n);
        dfs(board, i, j - 1, m, n);
        dfs(board, i, j + 1, m, n);
    }
}
