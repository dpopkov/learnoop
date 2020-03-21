package learn.oop.jpdppp.examples.iterators.decorated;

import java.util.Iterator;
import java.util.function.Function;

public class MapIterator<T, R> implements Iterator<R> {
    private final Iterator<T> iterator;
    private final Function<T, R> function;

    public MapIterator(Iterator<T> iterator, Function<T, R> function) {
        this.iterator = iterator;
        this.function = function;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public R next() {
        T next = iterator.next();
        return function.apply(next);
    }
}
