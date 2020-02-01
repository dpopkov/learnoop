package learn.oop.acdpsp.ch07decorators.simple;

import learn.oop.acdpsp.ch07decorators.Component;

public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent.operation");
    }
}
