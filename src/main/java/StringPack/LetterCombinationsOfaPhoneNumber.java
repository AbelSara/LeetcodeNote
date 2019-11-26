package StringPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    List<String> res = new ArrayList<>();
    HashMap<Integer, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        for (int i = 2; i <= 9; ++i) {
            List<Character> letters = new ArrayList<>();
            switch (i + '0') {
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                    for (char c = (char) ('a' + 3 * (i + '0' - '2')); c < 'a' + 3 * (i + '0' - '1'); c++)
                        letters.add(c);
                    break;
                case '7':
                    for (char c = 'p'; c <= 's'; c++)
                        letters.add(c);
                    break;
                case '8':
                    for (char c = 't'; c <= 'v'; c++)
                        letters.add(c);
                    break;
                case '9':
                    for (char c = 'w'; c <= 'z'; c++)
                        letters.add(c);
                    break;
            }
            map.put(i, letters);
        }
        StringBuilder sb = new StringBuilder();
        combineStr(sb, digits, 0);
        return res;
    }

    private void combineStr(StringBuilder sb, String digits, int i) {
        if (i >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        List<Character> list = map.get(digits.charAt(i) - '0');
        for (char c : list) {
            sb.append(c);
            combineStr(sb, digits, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
