package learn.oop.jpdppp.examples.composites.cookbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

public class Cookbook {
    private static final Map<String, Recipe> COOKBOOK = new HashMap<>();

    public static void main(String[] args) {
        addRecipes();
        System.out.println("\n---VEGAN RECIPES---");
        printRecipes(Recipe::isVegan);
        System.out.println("\n---RECIPES USING 4+ ITEMS---");
        printRecipes(r -> foodsUsed1(r) >= 4);
        printRecipes(r -> foodsUsed2(r) >= 4);
        printRecipes(r -> foodsUsed3(r) >= 4);
        System.out.println("\n---RECIPES COMPRISING SALAD---");
        printRecipesUsedIn1(COOKBOOK.get("salad"));
        printRecipesUsedIn2(COOKBOOK.get("salad"));
        System.out.println("\n---SHOPPING LIST FOR SALAD---");
        printShoppingList(COOKBOOK.get("salad"), 1);
    }

    private static void printShoppingList(Recipe r, int numPortions) {
        Iterator<FoodItem> it = r.childIterator();
        while (it.hasNext()) {
            FoodItem item = it.next();
            int amt = r.getQuantity(item) * numPortions;
            if (item instanceof BasicFood) {
                System.out.println(item.name() + " " + amt);
            } else {
                printShoppingList((Recipe) item, amt);
            }
        }
    }

    private static void printRecipesUsedIn1(Recipe r) {
        for (FoodItem item : r) {
            if (item instanceof Recipe) {
                System.out.println(item.name());
            }
        }
    }

    private static void printRecipesUsedIn2(Recipe r) {
        r.forEach(item -> {
            if (item instanceof Recipe) {
                System.out.println(item.name());
            }
        });
    }

    private static int foodsUsed1(FoodItem r) {
        int count = 0;
        if (r instanceof BasicFood) {
            count = 1;
        } else {
            Iterator<FoodItem> it = r.childIterator();
            while (it.hasNext()) {
                count += foodsUsed1(it.next());
            }
        }
        return count;
    }

    @SuppressWarnings("WhileLoopReplaceableByForEach")
    private static int foodsUsed2(FoodItem r) {
        int count = 0;
        Iterator<FoodItem> it = r.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof BasicFood) {
                count++;
            }
        }
        return count;
    }

    private static int foodsUsed3(FoodItem r) {
        int count = 0;
        for (FoodItem item : r) {
            if (item instanceof BasicFood) {
                count++;
            }
        }
        return count;
    }

    private static void addRecipes() {
        Recipe dressing = new Recipe("dressing", "Mix well.");
        dressing.addIngredient(new BasicFood("oil", true), 4);
        dressing.addIngredient(new BasicFood("vinegar", true), 2);
        COOKBOOK.put("dressing", dressing);

        Recipe salad = new Recipe("salad", "Chop lettuce, add bacon. Pour dressing over it.");
        salad.addIngredient(new BasicFood("lettuce", true), 1);
        salad.addIngredient(new BasicFood("bacon", false), 6);
        salad.addIngredient(dressing, 1);
        COOKBOOK.put("salad", salad);
    }

    private static void printRecipes(Predicate<Recipe> predicate) {
        for (Recipe r : COOKBOOK.values()) {
            if (predicate.test(r)) {
                System.out.println(r);
            }
        }
    }
}
