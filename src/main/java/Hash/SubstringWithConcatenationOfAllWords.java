package Hash;

import java.util.*;

/**
 * @author Honghan Zhu
 * @leetcode 30
 * @grade hard
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resList = new ArrayList<>();
        if (s.isEmpty() || words.length == 0)
            return resList;
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            if (word != null) {
                int times = dict.getOrDefault(word, 0) + 1;
                dict.put(word, times);
            }
        }
        int needMathces = dict.size();
        int lenOfSingleWord = words[0].length();
        int lenOfWords = lenOfSingleWord * words.length;
        int matches = 0;
        Map<String, Integer> curWords = new HashMap<>();
        for (int i = 0; i < lenOfSingleWord; i++) {
            int l = i, r = i;
            while (r <= s.length() - lenOfSingleWord) {
                String val = s.substring(r, r + lenOfSingleWord);
                if (dict.containsKey(val)) {
                    int times = curWords.getOrDefault(val, 0) + 1;
                    curWords.put(val, times);
                    if (times == dict.get(val))
                        matches += 1;
//                    while (times > dict.get(val)) {
//                        String delectStr = s.substring(l, l + lenOfSingleWord);
//                        if (curWords.containsKey(delectStr)) {
//                            int delTimes = curWords.get(delectStr) - 1;
//                            if (delTimes == dict.get(delectStr) - 1)
//                                matches -= 1;
//                            if (delTimes == 0)
//                                curWords.remove(delectStr);
//                        }
//                        if (val == delectStr)
//                            times -= 1;
//                        l += lenOfSingleWord;
//                    }
                }
                while (matches == needMathces && r - l + lenOfSingleWord >= lenOfWords) {
                    String str = s.substring(l, l + lenOfSingleWord);
                    if (r - l + lenOfSingleWord == lenOfWords) {
                        resList.add(l);
                        int times = curWords.get(str) - 1;
                        curWords.put(str, times);
                        if (times < dict.get(str))
                            matches -= 1;
                    } else if (dict.containsKey(str)) {
                        int times = curWords.getOrDefault(str, 0);
                        if (times > 0) {
                            times -= 1;
                            curWords.put(str, times);
                            if (times < dict.get(str))
                                matches -= 1;
                        }
                    }
                    l += lenOfSingleWord;
                }
                r += lenOfSingleWord;
            }
            curWords.clear();
            matches = 0;
        }
        for (int i : resList)
            System.out.println(i);
        return resList;
    }

    public static void main(String[] args) {
        new SubstringWithConcatenationOfAllWords().findSubstring("abababab",
                new String[]{"ab", "ba"});
    }
}