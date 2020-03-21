package learn.oop.jpdppp.examples.composites;

import java.util.function.Predicate;

public class AndPredicate<T> extends CompositePredicate<T> {
    protected AndPredicate(Predicate<T> p1, Predicate<T> p2) {
        super(p1, p2);
    }

    @Override
    public boolean test(T t) {
        return p1.test(t) && p2.test(t);
    }
}
