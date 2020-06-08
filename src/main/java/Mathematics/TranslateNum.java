package Mathematics;

/**
 * @author Honghan Zhu
 * @面试题 46
 * @grade medium
 */
public class TranslateNum {
    int sum = 0;

    public int translateNum(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int len = str.length;
        trans(str, 0, len);
        return sum;
    }

    private void trans(char[] str, int idx, int len){
        if(idx == len){
            ++sum;
            return;
        }
        int value = str[idx++] - '0';
        trans(str, idx, len);
        if(value != 0 && idx < len){
            value = value * 10 + str[idx++] - '0';
            if(value <= 25)
                trans(str, idx, len);
        }
    }
}
