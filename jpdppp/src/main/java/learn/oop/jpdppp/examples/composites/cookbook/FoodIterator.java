package learn.oop.jpdppp.examples.composites.cookbook;

import java.util.*;

public class FoodIterator implements Iterator<FoodItem> {
    private final Deque<Iterator<FoodItem>> stack = new ArrayDeque<>();

    public FoodIterator(FoodItem foodItem) {
        Collection<FoodItem> c = Collections.singleton(foodItem);
        stack.push(c.iterator());
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public FoodItem next() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        Iterator<FoodItem> peeked = stack.peek();
        FoodItem food = peeked.next();
        if (!peeked.hasNext()) {
            stack.pop();
        }
        Iterator<FoodItem> it = food.childIterator();
        if (it.hasNext()) {
            stack.push(it);
        }
        return food;
    }
}
