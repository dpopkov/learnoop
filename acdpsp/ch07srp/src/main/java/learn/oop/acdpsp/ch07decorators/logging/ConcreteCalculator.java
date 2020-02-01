package learn.oop.acdpsp.ch07decorators.logging;

public class ConcreteCalculator implements Calculator {
    @Override
    public int add(int x, int y) {
        return x + y;
    }
}
