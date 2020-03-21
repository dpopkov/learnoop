package learn.oop.jpdppp.examples.iterators.streams;

import java.util.Arrays;
import java.util.Collection;

public class SimpleStreamUsage {
    public static void main(String[] args) {
        Collection<String> c = Arrays.asList("a", "bb", "ccc", "dddd");
        new SimpleStream<>(c.iterator())
                .filter(s -> s.length() > 1)
                .filter(s -> s.length() < 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        Integer max = new SimpleStream<>(c.iterator())
                .filter(s -> s.length() > 1)
                .filter(s -> s.length() < 4)
                .map(String::length)
                .reduce(0, Math::max);
        System.out.println("The max length is " + max);
    }
}
