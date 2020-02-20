package BFS;

import java.util.*;

/**
 * @author Honghan Zhu
 * @leetcode 126
 * @grade hard
 */
public class WordLadderPlus {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> tmpList = new LinkedList<>();
        if (!wordList.contains(endWord))
            return tmpList;
        Map<String, Set<String>> dict = generatePatternMap(wordList);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        tmpList.add(list);
        tmpList = bfs(tmpList, dict, new HashSet<>(), endWord);
        List<List<String>> resList = new ArrayList<>();
        for (List<String> l : tmpList) {
            if (l.get(l.size() - 1).equals(endWord))
                resList.add(l);
        }
        return resList;
    }

    private List<List<String>> bfs(List<List<String>> preList, Map<String, Set<String>> dict, Set<String> visited, String endWord) {
        if (preList.isEmpty()) return null;
        List<List<String>> res = new LinkedList<>();
        boolean found = false;
        for (List<String> list : preList) {
            String lastWord = list.get(list.size() - 1);
            visited.add(lastWord);
            Set<String> neighborSet = getNeighbor(dict, lastWord);
            for (String neighbor : neighborSet) {
                if (visited.contains(neighbor))
                    continue;
                if (neighbor.equals(endWord))
                    found = true;
                List<String> nextList = new ArrayList<>(list);
                nextList.add(neighbor);
                res.add(nextList);
            }
        }
        return found ? res : bfs(res, dict, visited, endWord);
    }

    private Set<String> getNeighbor(Map<String, Set<String>> map, String str) {
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
