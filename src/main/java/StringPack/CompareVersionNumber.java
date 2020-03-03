package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 165
 * @grade medium
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < v1.length && j < v2.length){
            int curV1 = Integer.valueOf(v1[i]);
            int curV2 = Integer.valueOf(v2[j]);
            if(curV1 < curV2)
                return -1;
            else if(curV1 >curV2)
                return 1;
        }
        while(i != v1.length) {
            if(Integer.valueOf(v1[i++]) > 0)
                return 1;
        }
        while(j != v2.length) {
            if(Integer.valueOf(v2[j++]) > 0)
                return -1;
        }

        return 0;
    }
}
