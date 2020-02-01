package StringPack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 93
 * @grade medium
 */
public class RestoreIpAddress {
    List<String> resList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack("", s, 0, 0);
        return resList;
    }

    private void backtrack(String ip, String s, int idx, int times) {
        if (times >= 4 && idx < s.length())
            return;
        if (idx >= s.length()) {
            resList.add(ip.substring(1));
            return;
        }
        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            String partIp = s.substring(idx, idx + i);
            if (partIp.charAt(0) == '0' && partIp.length() > 1)
                break;
            int partIpNum = Integer.valueOf(partIp);
            if (partIpNum > 0 && partIpNum < 256) {
                backtrack(ip + "." + partIp, s, idx + i, times + 1);
            }
        }
    }
}
