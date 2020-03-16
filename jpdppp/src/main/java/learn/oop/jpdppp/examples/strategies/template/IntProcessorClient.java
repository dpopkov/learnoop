package learn.oop.jpdppp.examples.strategies.template;

public class IntProcessorClient {
    public static void main(String[] args) {
        IntProcessor p1 = new AddOne();
        IntProcessor p2 = new AddTwo();
        p1.operateOn(6);
        p2.operateOn(6);
    }
}
