package learn.oop.jpdppp.examples.composites.cookbook;

import java.util.Iterator;

public interface FoodItem extends Iterable<FoodItem> {
    String name();
    boolean isVegan();
    /** Returns an iterator that contains the children of the given food item. */
    Iterator<FoodItem> childIterator();

    /** Returns an iterator that performs a complete traversal of the tree rooted at a given object. */
    default Iterator<FoodItem> iterator() {
        return new FoodIterator(this);
    }
}
