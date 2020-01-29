package learn.oop.acdpsp.ch04interf.strategy;

public class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("ConcreteStrategyB.execute");
    }
}
