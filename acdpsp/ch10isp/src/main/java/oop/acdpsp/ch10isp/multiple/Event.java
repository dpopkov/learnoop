package oop.acdpsp.ch10isp.multiple;

public abstract class Event<E> {
    private final String name;

    public Event(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
