package learn.oop.jpdppp.examples.iterators.decorated;

import java.util.Arrays;
import java.util.Collection;

public class DecoratedIteratorsUsage {
    public static void main(String[] args) {
        Collection<String> c = Arrays.asList("a", "bb", "ccc", "dddd");
        // Print the strings whose length is between 2 and 3 in uppercase
        var i1 = c.iterator();
        var i2 = new FilterIterator<>(i1, s -> s.length() > 1);
        var i3 = new FilterIterator<>(i2, s -> s.length() < 4);
        var i4 = new MapIterator<>(i3, String::toUpperCase);
        while (i4.hasNext()) {
            System.out.println(i4.next());
        }
        // Print the maximum length of those strings
        var j1 = c.iterator();
        var j2 = new FilterIterator<>(j1, s -> s.length() > 1);
        var j3 = new FilterIterator<>(j2, s -> s.length() < 4);
        var j4 = new MapIterator<>(j3, String::length);
        int max = -1;
        while (j4.hasNext()) {
            Integer n = j4.next();
            if (n > max) {
                max = n;
            }
        }
        System.out.println("The max length is " + max);
    }
}
