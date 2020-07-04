package learn.oop.linkeddp.creational.factorymethod;

import java.util.List;

public class CandyStore {
    public static Candy getCandy(String type) {
        switch (type) {
            case "hard candy":
                return new HardCandy();
            case "chocolate":
                return new Chocolate();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static List<Candy> candyPackage(int quantity, String type) {
        Candy candy = getCandy(type);
        return candy.makeCandyPackage(quantity);
    }
}
