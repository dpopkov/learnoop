package learn.oop.springdp.springdp.factory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class BasePet implements Pet {

    private String name;
}
