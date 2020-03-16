package learn.oop.jpdppp.examples.strategies.strategy;

public class IntProcessor {
    private final Operation operation;

    public IntProcessor(Operation operation) {
        this.operation = operation;
    }

    public void operateOn(int x) {
        int y = operation.f(x);
        System.out.println(x + " becomes " + y);
    }
}
