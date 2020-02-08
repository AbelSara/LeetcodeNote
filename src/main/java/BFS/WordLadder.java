package BFS;

import java.util.*;

/**
 * @Author Honghan Zhu
 * @leetcode 127
 * @grade medium
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Map<String, Set<String>> patternMap = generatePatternMap(wordList);
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        return bfs(patternMap, visited, 1, beginSet, endSet);
    }

    private int bfs(Map<String, Set<String>> patternMap, Set<String> visited,
                    int level, Set<String> beginSet, Set<String> endSet) {
        Set<String> nextBeginSet = new HashSet<>();
        for (String str : beginSet) {
            if (!visited.contains(str)) {
                visited.add(str);
                Set<String> neighborSet = getSet(patternMap, str);
                for (String neighbor : neighborSet) {
                    if (endSet.contains(neighbor)) return level + 1;
                }
                nextBeginSet.addAll(neighborSet);
            }
        }
        if (nextBeginSet.isEmpty())
            return 0;
        if (endSet.size() < nextBeginSet.size()) {
            beginSet = endSet;
            endSet = nextBeginSet;
            nextBeginSet = beginSet;
        }
        return bfs(patternMap, visited, level + 1, nextBeginSet, endSet);
    }

    private Set<String> getSet(Map<String, Set<String>> map, String str) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            String tmpStr = str.substring(0, i) + "*" + str.substring(i + 1, str.length());
            Set<String> tmpSet = map.get(tmpStr);
            if (null != tmpSet)
                set.addAll(tmpSet);
        }
        return set;
    }

    private Map<String, Set<String>> generatePatternMap(List<String> strs) {
        Map<String, Set<String>> resMap = new HashMap<>();
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                String newStr = s.substring(0, i) + "*" + s.substring(i + 1, s.length());
                if (resMap.get(newStr) == null)
                    resMap.put(newStr, new HashSet<>());
                resMap.get(newStr).add(s);
            }
        }
        return resMap;
    }
}
