package learn.oop.acdpsp.ch07decorators.lazy;

import learn.oop.acdpsp.ch07decorators.Component;

public class LazyComponent implements Component {
    private final Lazy<Component> lazyComponent;

    public LazyComponent(Lazy<Component> lazyComponent) {
        this.lazyComponent = lazyComponent;
    }

    @Override
    public void operation() {
        System.out.println("LazyComponent.operation");
        lazyComponent.value().operation();
    }
}
