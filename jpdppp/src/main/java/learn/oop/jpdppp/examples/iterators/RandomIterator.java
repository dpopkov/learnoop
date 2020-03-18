package learn.oop.jpdppp.examples.iterators;

import java.util.Iterator;
import java.util.Random;

public class RandomIterator implements Iterator<Integer> {
    private final Random rand = new Random();
    private final int bound;

    public RandomIterator(int bound) {
        this.bound = bound;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return bound > 0 ? rand.nextInt(bound) : rand.nextInt();
    }
}
