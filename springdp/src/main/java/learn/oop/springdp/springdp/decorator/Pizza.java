package learn.oop.springdp.springdp.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pizza {

    protected String description;

    public abstract BigDecimal getCost();

}
