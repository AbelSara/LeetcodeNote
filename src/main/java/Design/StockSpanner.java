package Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Honghan Zhu
 * @leetcode 901
 * @grade medium
 */
public class StockSpanner {
    Stack<Integer> stack;
    List<Integer> stock;

    public StockSpanner() {
        stock = new ArrayList<>();
        stack = new Stack<>();
        stack.push(-1);
    }

    public int next(int price) {
        stock.add(price);
        while (stack.peek() != -1 && stock.get(stack.peek()) <= price)
            stack.pop();
        int ans = stock.size() - stack.peek() - 1;
        stack.push(stock.size() - 1);
        return ans;
    }

}
