package learn.oop.acdpsp.ch07decorators.predicated;

import learn.oop.acdpsp.ch07decorators.Component;

import java.util.function.Predicate;

public class PredicatedComponent implements Component {
    private final Component decoratedComponent;
    private final Predicate<Component> predicate;

    public PredicatedComponent(Component decoratedComponent, Predicate<Component> predicate) {
        this.decoratedComponent = decoratedComponent;
        this.predicate = predicate;
    }

    @Override
    public void operation() {
        System.out.println("PredicatedComponent.operation");
        if (predicate.test(decoratedComponent)) {
            decoratedComponent.operation();
        }
    }
}
