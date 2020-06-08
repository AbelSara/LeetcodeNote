package Arrays;

/**
 * @author Honghan Zhu
 * @leetcode 990
 * @grade medium
 */
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        boolean[][] equalMatrix = new boolean[26][26];
        for(String s : equations){
            char equal = s.charAt(1);
            if(equal == '!')
                continue;
            int a = s.charAt(0) - 'a', b = s.charAt(3) - 'a';
            equalMatrix[a][b] = true;
            equalMatrix[b][a] = true;
        }
        for(int i = 0; i < 26; ++i){
            for(int j = 0; j < 26; ++j){
                if(!equalMatrix[i][j]) continue;
                for(int k = 0; k < 26; ++k){
                    if(equalMatrix[j][k])
                        equalMatrix[i][k] = true;
                }
            }
        }
        for(String s : equations){
            char equal = s.charAt(1);
            if(equal == '=')
                continue;
            int a = s.charAt(0) - 'a', b = s.charAt(3) - 'a';
            if(a == b || equalMatrix[a][b]) return false;
        }
        return true;
    }
}
