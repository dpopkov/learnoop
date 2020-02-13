package oop.acdpsp.ch10isp;

public interface Read<E> {
    E readOne(long id);

    Iterable<E> readAll();
}
