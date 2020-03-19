package learn.oop.jpdppp.bank.iterators;

import java.util.function.Consumer;

/**
 * Visitor that is a consumer returning total result.
 * @param <T> type of the elements it visits
 * @param <R> type of the result value
 */
public interface Visitor<T, R> extends Consumer<T> {
    R result();
}
