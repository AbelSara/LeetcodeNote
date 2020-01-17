package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Honghan Zhu
 * @leetcode 36
 * @grade medium
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set[] rowSet = new HashSet[9];
        Set[] colSet = new HashSet[9];
        Set[] partSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet();
            colSet[i] = new HashSet();
            partSet[i] = new HashSet();
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                int partNum = i / 3 * 3 + j / 3;
                char c = board[i][j];
                if (c == '.') continue;
                else if (rowSet[i].contains(c) || colSet[j].contains(c) || partSet[partNum].contains(c))
                    return false;
                rowSet[i].add(c);
                colSet[j].add(c);
                partSet[partNum].add(c);
            }
        }
        return true;
    }
}
