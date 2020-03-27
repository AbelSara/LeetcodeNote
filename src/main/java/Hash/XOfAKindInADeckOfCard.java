package Hash;

/**
 * @author Honghan Zhu
 * @leetcode 914
 * @grade easy
 */
public class XOfAKindInADeckOfCard {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        int[] dict = new int[len + 1];
        for (int i = 0; i < len; i++) {
            dict[deck[i]] += 1;
        }
        int group = Integer.MAX_VALUE;
        for (int i = 0; i <= len; i++) {
            if (dict[i] < 2)
                continue;
            group = Math.min(group, dict[i]);
            int divide = divisor(group, dict[i]);
            group = divide < 2 ? group : Math.min(group, divide);
        }
        if (group == Integer.MAX_VALUE)
            return false;
        for (int i = 0; i <= len; i++) {
            if (dict[i] == 0 || dict[i] % group == 0)
                continue;
            return false;
        }
        return true;
    }

    private int divisor(int a, int b)
    {
        int temp;
        if (a < b)
        {
            temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
