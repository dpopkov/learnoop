package learn.oop.acdpsp.ch04interf.strategy;

public class Context {
    private final Strategy strategyA = new ConcreteStrategyA();
    private final Strategy strategyB = new ConcreteStrategyB();
    private Strategy currentStrategy;

    public Context() {
        this.currentStrategy = strategyA;
    }

    public void exhibitVariantBehavior() {
        currentStrategy.execute();
        swapStrategies();
    }

    private void swapStrategies() {
        currentStrategy = (currentStrategy == strategyA) ? strategyB : strategyA;
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.exhibitVariantBehavior();
        context.exhibitVariantBehavior();
    }
}
