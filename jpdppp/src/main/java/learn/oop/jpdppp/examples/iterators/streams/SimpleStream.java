package learn.oop.jpdppp.examples.iterators.streams;

import learn.oop.jpdppp.examples.iterators.decorated.FilterIterator;
import learn.oop.jpdppp.examples.iterators.decorated.MapIterator;

import java.util.Iterator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStream<T> {
    private final Iterator<T> iterator;

    public SimpleStream(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public SimpleStream<T> filter(Predicate<T> predicate) {
        Iterator<T> filtered = new FilterIterator<>(iterator, predicate);
        return new SimpleStream<>(filtered);
    }

    public <R> SimpleStream<R> map(Function<T, R> function) {
        Iterator<R> mapped = new MapIterator<>(iterator, function);
        return new SimpleStream<>(mapped);
    }

    public void forEach(Consumer<T> consumer) {
        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    public T reduce(T identity, BinaryOperator<T> operator) {
        T result = identity;
        while (iterator.hasNext()) {
            T t = iterator.next();
            result = operator.apply(result, t);
        }
        return result;
    }
}
