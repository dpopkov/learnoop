package oop.acdpsp.ch10isp.multiple;

/** Interface for publishing events. */
public interface EventPublisher<E> {
    void publish(Event<E> event);
}
