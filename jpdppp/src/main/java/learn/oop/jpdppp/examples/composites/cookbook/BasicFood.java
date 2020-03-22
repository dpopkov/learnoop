package learn.oop.jpdppp.examples.composites.cookbook;

import java.util.Collections;
import java.util.Iterator;

public class BasicFood implements FoodItem {
    private final String name;
    private final boolean isVegan;

    public BasicFood(String name, boolean isVegan) {
        this.name = name;
        this.isVegan = isVegan;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isVegan() {
        return isVegan;
    }

    @Override
    public Iterator<FoodItem> childIterator() {
        return Collections.emptyIterator();
    }

    @Override
    public String toString() {
        return name + (isVegan ? " (vegan)" : "");
    }
}
