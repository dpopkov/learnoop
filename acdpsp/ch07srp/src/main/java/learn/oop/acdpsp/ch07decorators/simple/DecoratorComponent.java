package learn.oop.acdpsp.ch07decorators.simple;

import learn.oop.acdpsp.ch07decorators.Component;

public class DecoratorComponent implements Component {
    private final Component decoratedComponent;

    public DecoratorComponent(Component decoratedComponent) {
        this.decoratedComponent = decoratedComponent;
    }

    @Override
    public void operation() {
        System.out.println("DecoratorComponent.operation");
        decoratedComponent.operation();
    }
}
