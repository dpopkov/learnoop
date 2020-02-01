package learn.oop.acdpsp.ch07decorators.composite;

import learn.oop.acdpsp.ch07decorators.Component;

public class LeafComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf.operation");
    }
}
