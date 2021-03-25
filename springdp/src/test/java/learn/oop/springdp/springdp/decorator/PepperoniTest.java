package learn.oop.springdp.springdp.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PepperoniTest {

    @Test
    void test() {
        Pizza pizza = new ThickCrustPizza();
        assertEquals("Thick Crust Pizza", pizza.getDescription());
        assertEquals(new BigDecimal("15.00"), pizza.getCost());

        Pepperoni pepperoni = new Pepperoni(pizza);
        assertEquals("Thick Crust Pizza + Pepperoni", pepperoni.getDescription());
        assertEquals(new BigDecimal("16.50"), pepperoni.getCost());

        Pepperoni doublePepperoni = new Pepperoni(pepperoni);
        assertEquals("Thick Crust Pizza + Pepperoni + Pepperoni", doublePepperoni.getDescription());
        assertEquals(new BigDecimal("18.00"), doublePepperoni.getCost());
    }
}
