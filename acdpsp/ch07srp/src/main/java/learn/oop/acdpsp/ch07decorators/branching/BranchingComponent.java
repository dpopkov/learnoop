package learn.oop.acdpsp.ch07decorators.branching;

import learn.oop.acdpsp.ch07decorators.Component;

import java.util.function.Predicate;

public class BranchingComponent implements Component {
    private final Component trueComponent;
    private final Component falseComponent;
    private final Predicate<Component> predicate;

    public BranchingComponent(Component trueComponent, Component falseComponent, Predicate<Component> predicate) {
        this.trueComponent = trueComponent;
        this.falseComponent = falseComponent;
        this.predicate = predicate;
    }

    @Override
    public void operation() {
        System.out.println("BranchingComponent.operation");
        if (predicate.test(trueComponent)) {
            trueComponent.operation();
        } else {
            falseComponent.operation();
        }
    }
}
