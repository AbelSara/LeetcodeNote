package string;

/**
 * Author:Honghan Zhu
 * leetcode:28
 * Grade:easy
 */
public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }else if(haystack.equals(needle)){
            return 0;
        }
        int result=-1;
        for(int start=0,end=needle.length();end<=haystack.length();start++,end++){
            String tempStr=haystack.substring(start,end);
            if(end>=start&&tempStr.equals(needle)){
                result=start;
                break;
            }
        }
        return result;
    }
}
