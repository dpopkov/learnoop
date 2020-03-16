package learn.oop.jpdppp.examples.strategies.template;

public class AddOne extends IntProcessor {
    @Override
    protected int f(int x) {
        return x + 1;
    }
}
