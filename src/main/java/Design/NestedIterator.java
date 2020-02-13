package Design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Honghan Zhu
 * @leetcode 341
 * @grade medium
 */
public class NestedIterator implements Iterator<Integer> {
    LinkedList<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        iterator = initialIterator(nestedList);
    }

    private LinkedList<Integer> initialIterator(List<NestedInteger> nestedList) {
        LinkedList<Integer> list = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger())
                list.add(nestedInteger.getInteger());
            else
                list.addAll(initialIterator(nestedInteger.getList()));
        }
        return list;
    }

    @Override
    public Integer next() {
        return iterator.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !iterator.isEmpty();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}