package Hash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author Honghan Zhu
 * @leetcode 187
 * @grade medium
 */
public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resList = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String dna = s.substring(i, i + 10);
            if (set.contains(dna) && !resList.contains(dna))
                resList.add(dna);
            set.add(dna);
        }
        return resList;
    }
}
