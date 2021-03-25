package learn.oop.springdp.springdp.decorator;

import java.math.BigDecimal;

public class Pepperoni extends PizzaIngredient {
    private final Pizza pizza;

    public Pepperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Pepperoni";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("1.50").add(pizza.getCost());
    }
}
