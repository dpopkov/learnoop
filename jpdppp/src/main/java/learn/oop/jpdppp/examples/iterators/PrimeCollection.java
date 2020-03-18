package learn.oop.jpdppp.examples.iterators;

import java.util.AbstractCollection;
import java.util.Iterator;

public class PrimeCollection extends AbstractCollection<Integer> {
    private final int size;

    public PrimeCollection(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimeIterator(size);
    }

    @Override
    public int size() {
        return size;
    }
}
