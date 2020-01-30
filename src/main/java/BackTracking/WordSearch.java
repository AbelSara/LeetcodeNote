package BackTracking;

/**
 * @Author Honghan Zhu
 * @leetcode 79
 * @grade medium
 */
public class WordSearch {
    int[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new int[board.length][board[0].length];
        char[] str = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (backTrack(board, str, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, char[] str, int idx, int i, int j) {
        if (board[i][j] == str[idx] && visited[i][j] == 0) {
            visited[i][j] = 1;
            if (idx == str.length - 1)
                return true;
            if (i - 1 >= 0 && backTrack(board, str, idx + 1, i - 1, j))
                return true;
            if (i + 1 < board.length && backTrack(board, str, idx + 1, i + 1, j))
                return true;
            if (j - 1 >= 0 && backTrack(board, str, idx + 1, i, j - 1))
                return true;
            if (j + 1 < board[0].length && backTrack(board, str, idx + 1, i, j + 1))
                return true;
            visited[i][j] = 0;
        }
        return false;
    }
}
