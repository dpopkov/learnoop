package learn.oop.linkeddp.creational.factorymethod;

import java.util.List;

public abstract class Candy {
    public abstract List<Candy> makeCandyPackage(int quantity);
}
