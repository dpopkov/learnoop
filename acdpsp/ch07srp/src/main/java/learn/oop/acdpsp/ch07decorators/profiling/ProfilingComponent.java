package learn.oop.acdpsp.ch07decorators.profiling;

import learn.oop.acdpsp.ch07decorators.Component;

public class ProfilingComponent implements Component {
    private final Component decoratedComponent;
    private final Stopwatch stopwatch;

    public ProfilingComponent(Component decoratedComponent, Stopwatch stopwatch) {
        this.decoratedComponent = decoratedComponent;
        this.stopwatch = stopwatch;
    }

    @Override
    public void operation() {
        stopwatch.start();
        decoratedComponent.operation();
        stopwatch.stop();
        System.out.printf("The method took %d milliseconds to complete%n", stopwatch.elapsedMilliseconds() / 1000);
    }
}
