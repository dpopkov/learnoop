package learn.oop.acdpsp.ch07decorators.simple;

import learn.oop.acdpsp.ch07decorators.Component;

public class Client {
    public static void main(String[] args) {
        Component component = new DecoratorComponent(new ConcreteComponent());
        component.operation();
    }
}
