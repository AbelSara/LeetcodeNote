package Hash;

import java.util.Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 205
 * @grade easy
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        char[] sourceToDest = new char[256];
        char[] destToSource = new char[256];
        Arrays.fill(sourceToDest, '.');
        Arrays.fill(destToSource, '.');
        if(s.length() != t.length())
            return false;
        int len = s.length();
        for(int i = 0; i < len; i++){
            char curSource = s.charAt(i);
            char curDest = t.charAt(i);
            if((sourceToDest[curSource] != '.' && sourceToDest[curSource] != curDest) || (destToSource[curDest] != '.' && destToSource[curDest] != curSource))
                return false;
            sourceToDest[curSource] = curDest;
            destToSource[curDest] = curSource;
        }
        return true;
    }
}
