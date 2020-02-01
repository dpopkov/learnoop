package learn.oop.acdpsp.ch07decorators.composite;

import learn.oop.acdpsp.ch07decorators.Component;

public class Client {
    public static void main(String[] args) {
        CompositeComponent compositeComponent = new CompositeComponent();
        compositeComponent.add(new LeafComponent());
        compositeComponent.add(new LeafComponent());
        compositeComponent.add(new LeafComponent());

        Component component = compositeComponent;
        component.operation();
    }
}
