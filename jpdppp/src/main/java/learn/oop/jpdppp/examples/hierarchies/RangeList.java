package learn.oop.jpdppp.examples.hierarchies;

import java.util.AbstractList;

public class RangeList extends AbstractList<Integer> {
    private int limit;

    public RangeList(int length) {
        limit = length;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return limit;
    }
}
