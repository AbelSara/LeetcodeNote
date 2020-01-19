package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 54
 * @grade medium
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0)
            return res;
        int rs = 0, re = matrix.length - 1, cs = 0, ce = matrix[0].length - 1;
        while (true) {
            for (int i = cs; i <= ce; i++) {
                res.add(matrix[rs][i]);
            }
            if (++rs > re)
                break;
            for (int i = rs; i <= re; i++) {
                res.add(matrix[i][ce]);
            }
            if (++cs > ce)
                break;
            for (int i = ce; i >= cs; i--) {
                res.add(matrix[re][i]);
            }
            if (--re < rs)
                break;
            for (int i = re; i >= rs; i--) {
                res.add(matrix[i][cs]);
            }
            if (--ce < cs)
                break;
        }
        return res;
    }
}
