package learn.oop.jpdppp.examples.strategies.strategy;

public class IntProcessorClient {
    public static void main(String[] args) {
        IntProcessor p1 = new IntProcessor(x -> x + 1);
        IntProcessor p2 = new IntProcessor(x -> x + 2);
        p1.operateOn(6);
        p2.operateOn(6);
    }
}
