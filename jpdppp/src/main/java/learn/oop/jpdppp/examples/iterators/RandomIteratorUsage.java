package learn.oop.jpdppp.examples.iterators;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomIteratorUsage {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Needs bound");
            System.exit(-1);
        }
        int bound = Integer.parseInt(args[0]);
        Iterator<Integer> iterator = new RandomIterator(bound);
        Set<Integer> numbers = new HashSet<>();
        boolean dupeNotFound = true;
        while (dupeNotFound) {
            dupeNotFound = numbers.add(iterator.next());
        }
        System.out.println(numbers.size());
    }
}
