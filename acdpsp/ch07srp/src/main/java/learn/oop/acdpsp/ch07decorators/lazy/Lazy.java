package learn.oop.acdpsp.ch07decorators.lazy;

/** Contains value that should not be instantiated until its first use. */
public interface Lazy<T> {
    /** Returns value, when invoked first time it must instantiate it. */
    T value();
}
