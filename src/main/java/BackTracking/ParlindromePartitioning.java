package BackTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 131
 * @grade medium
 */
public class ParlindromePartitioning {
    List<List<String>> resList;

    public List<List<String>> partition(String s) {
        resList = new LinkedList<>();
        backtrack(s, new LinkedList<>(), 0);
        return resList;
    }

    private void backtrack(String s, LinkedList<String> list, int start) {
        if (start == s.length()) {
            resList.add(new LinkedList<>(list));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String tarStr = s.substring(start, end);
            if (isParlindrome(tarStr)) {
                list.add(tarStr);
                backtrack(s, list, end);
                list.removeLast();
            }
        }
    }

    private boolean isParlindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
