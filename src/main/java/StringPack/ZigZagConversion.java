package StringPack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honghan Zhu
 * @leetcode 6
 * @grade medium
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new StringBuilder());
        }
        for (int i = 0, row = 0, tag = 0; i < s.length(); i++) {
            //向高处移动
            if (tag == 0) {
                lists.get(row).append(s.charAt(i));
                row += 1;
                if (row == numRows - 1) {
                    tag = 1;
                }
            }
            //向低处移动
            else if (tag == 1) {
                lists.get(row).append(s.charAt(i));
                row -= 1;
                if (row == 0) {
                    tag = 0;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<lists.size();i++){
            result.append(lists.get(i));
        }
        return result.toString();
    }
}
