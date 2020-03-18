package learn.oop.jpdppp.examples.iterators;

import java.util.Iterator;

public class PrimeIteratorUsage {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Needs bound");
            System.exit(-1);
        }
        int bound = Integer.parseInt(args[0]);
        Iterator<Integer> iterator = new PrimeIterator(bound);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
