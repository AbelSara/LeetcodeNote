package String;

/**
 * @author Honghan Zhu
 * @leetcode 125
 * @grade easy
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char [] str=transferStr(s).toCharArray();
        int i=0,j=str.length-1;
        while(i<j){
            if(str[i++]!=str[j--]){
                return false;
            }
        }
        return true;
    }
    private String transferStr(String str){
        str=str.toLowerCase();
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
