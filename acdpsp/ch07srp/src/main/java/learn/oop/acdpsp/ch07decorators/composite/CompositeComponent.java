package learn.oop.acdpsp.ch07decorators.composite;

import learn.oop.acdpsp.ch07decorators.Component;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeComponent implements Component {
    private Collection<Component> children = new ArrayList<>();

    @Override
    public void operation() {
        System.out.println("CompositeComponent.operation");
        for (Component component : children) {
            component.operation();
        }
    }

    public void add(Component component) {
        children.add(component);
    }
}
