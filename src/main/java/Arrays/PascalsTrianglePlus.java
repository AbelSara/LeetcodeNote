package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 119
 * @grade easy
 */
public class PascalsTrianglePlus {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(temp.get(j - 1) + temp.get(j));
            }
            result.add(1);
            temp = result;
        }
        if (0 == result.size()) {
            result.add(1);
        }
        return result;
    }
}
