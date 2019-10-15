package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Honghan Zhu
 * @leetcode: 118
 * @grade: easy
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0, 1);
            if (i > 1) {
                List<Integer> tempList = result.get(i - 2);
                for (int j = 1; j < i - 1; j++) {
                    temp.add(j, tempList.get(j) + tempList.get(j - 1));
                }
            }
            if (i > 1) {
                temp.add(i - 1, 1);
            }
            result.add(temp);
        }
        return result;
    }
}
