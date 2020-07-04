package learn.oop.linkeddp.creational.factorymethod;

import java.util.ArrayList;
import java.util.List;

public class Chocolate extends Candy {
    @Override
    public List<Candy> makeCandyPackage(int quantity) {
        List<Candy> list = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            list.add(new Chocolate());
        }
        return list;
    }
}
