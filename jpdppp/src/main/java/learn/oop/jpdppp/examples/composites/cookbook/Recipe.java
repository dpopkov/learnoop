package learn.oop.jpdppp.examples.composites.cookbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Recipe implements FoodItem {
    private final String name;
    private final String directions;
    private final Map<FoodItem, Integer> ingredients = new HashMap<>();

    public Recipe(String name, String directions) {
        this.name = name;
        this.directions = directions;
    }

    public void addIngredient(FoodItem item, int qty) {
        ingredients.put(item, qty);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isVegan() {
        Iterator<FoodItem> it = childIterator();
        while (it.hasNext()) {
            if (!it.next().isVegan()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<FoodItem> childIterator() {
        return ingredients.keySet().iterator();
    }

    public int getQuantity(FoodItem item) {
        return ingredients.get(item);
    }

    @Override
    public String toString() {
        String veg = isVegan() ? " (vegan)" : "";
        StringBuilder result = new StringBuilder("Recipe for ");
        result.append(name).append(veg).append("\n");
        result.append("Ingredients");
        for (FoodItem item : ingredients.keySet()) {
            int qty = ingredients.get(item);
            result.append("\t").append(qty).append(" ").append(item.name()).append("\n");
        }
        return result.append("Directions: ").append(directions).append("\n").toString();
    }
}
