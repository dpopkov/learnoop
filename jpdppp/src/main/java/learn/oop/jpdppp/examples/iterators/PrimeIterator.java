package learn.oop.jpdppp.examples.iterators;

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {
    private final int howMany;
    private int current = 1;
    private int count = 0;

    public PrimeIterator(int howMany) {
        this.howMany = howMany;
    }

    @Override
    public boolean hasNext() {
        return count < howMany;
    }

    @Override
    public Integer next() {
        current++;
        while (!isPrime(current)) {
            current++;
        }
        count++;
        return current;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
