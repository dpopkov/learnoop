package oop.acdpsp.ch10isp.multiple;

/** Interface for subscribing to events. */
public interface EventSubscriber<E> {
    void subscribe(Event<E> event);
}
