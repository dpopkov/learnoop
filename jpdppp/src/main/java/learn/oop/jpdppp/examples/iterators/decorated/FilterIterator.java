package learn.oop.jpdppp.examples.iterators.decorated;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;
    private final Predicate<T> predicate;
    private T nextValue;
    private boolean found = false;

    public FilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        findNext();
        return found;
    }

    @Override
    public T next() {
        findNext();
        if (!found) {
            throw new NoSuchElementException();
        }
        found = false;
        return nextValue;
    }

    private void findNext() {
        while (!found && iterator.hasNext()) {
            T v = iterator.next();
            if (predicate.test(v)) {
                nextValue = v;
                found = true;
            }
        }
    }
}
