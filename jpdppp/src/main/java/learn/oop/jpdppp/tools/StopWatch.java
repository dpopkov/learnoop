package learn.oop.jpdppp.tools;

public class StopWatch {
    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public long stop() {
        return System.currentTimeMillis() - start;
    }
}
