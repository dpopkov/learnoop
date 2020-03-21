package learn.oop.jpdppp.examples.composites;

import java.util.function.Predicate;

public abstract class CompositePredicate<T> implements Predicate<T> {
    protected final Predicate<T> p1;
    protected final Predicate<T> p2;

    protected CompositePredicate(Predicate<T> p1, Predicate<T> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public abstract boolean test(T t);
}
