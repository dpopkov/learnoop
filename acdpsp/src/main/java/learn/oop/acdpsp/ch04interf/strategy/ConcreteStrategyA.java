package learn.oop.acdpsp.ch04interf.strategy;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("ConcreteStrategyA.execute");
    }
}
