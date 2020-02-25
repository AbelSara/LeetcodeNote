package BackTracking;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Honghan Zhu
 * @leetcode 37
 * @grade hard
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int len = 9;
        boolean[][] rowSet = new boolean[9][10];
        boolean[][] colSet = new boolean[9][10];
        boolean[][] partSet = new boolean[9][10];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int partNum = i / 3 * 3 + j / 3;
                char c = board[i][j];
                if(c != '.'){
                    int tar = c - '0';
                    rowSet[i][tar] = true;
                    colSet[j][tar] = true;
                    partSet[partNum][tar] = true;
                }
            }
        }
        backtrack(board, rowSet, colSet, partSet, 0, 0, 9);
    }

    private boolean backtrack(char[][] board, boolean[][] rowSet, boolean[][] colSet, boolean[][] partSet,
                              int r, int c, int len){
        int partNum = -1;
        int i = -1, j = -1;
        boolean foundFirstDot = false;
        while(c < len && !foundFirstDot){
            partNum = r / 3 * 3 + c / 3;
            char ch = board[r][c];
            if(ch == '.'){
                i = r;
                j = c;
                foundFirstDot = true;
            }
            c += 1;
        }
        for(r = r + 1; r < len && !foundFirstDot; r++){
            for(c = 0; c < len && !foundFirstDot; c++){
                partNum = r / 3 * 3 + c / 3;
                char ch = board[r][c];
                if(ch == '.') {
                    i = r;
                    j = c;
                    foundFirstDot = true;
                }
            }
        }
        if(i == -1 && j == -1)
            return true;
        for(int t = 1; t <= len; t++){
            if(!rowSet[i][t] && !colSet[j][t] && !partSet[partNum][t]){
                rowSet[i][t] = true;
                colSet[j][t] = true;
                partSet[partNum][t] = true;
                board[i][j] = (char)(t + '0');
                if(backtrack(board, rowSet, colSet, partSet, i, j, len))
                    return true;
                rowSet[i][t] = false;
                colSet[j][t] = false;
                partSet[partNum][t] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }

}
