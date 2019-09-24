package mathematics;

/**
 * Author:Honghan Zhu
 * leetcode:13
 * Grade:easy
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        char[] strArr = s.toCharArray();
        int result = 0;
        for (int i = 0; i < strArr.length; i++) {
            switch (strArr[i]) {
                case 'I':
                    if (i + 1 < strArr.length) {
                        if (strArr[i + 1] == 'V') {
                            result += 4;
                            i++;
                        } else if (strArr[i + 1] == 'X') {
                            result += 9;
                            i++;
                        } else {
                            result += 1;
                        }
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    if (i + 1 < strArr.length) {
                        if (strArr[i + 1] == 'L') {
                            result += 40;
                            i++;
                        } else if (strArr[i + 1] == 'C') {
                            result += 90;
                            i++;
                        } else {
                            result += 10;
                        }
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    if (i + 1 < strArr.length) {
                        if (strArr[i + 1] == 'D') {
                            result += 400;
                            i++;
                        } else if (strArr[i + 1] == 'M') {
                            result += 900;
                            i++;
                        } else {
                            result += 100;
                        }
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;
            }
        }
        return result;
    }
}
