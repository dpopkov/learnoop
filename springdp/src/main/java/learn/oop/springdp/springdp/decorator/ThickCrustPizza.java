package learn.oop.springdp.springdp.decorator;

import java.math.BigDecimal;

public class ThickCrustPizza extends Pizza {

    public ThickCrustPizza() {
        super("Thick Crust Pizza");
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("15.00");
    }
}
