package oop.acdpsp.ch10isp;

public interface CreateReadUpdate<E> {
    void create(E entity);

    E readOne(long id);

    Iterable<E> readAll();

    void update(E entity);
}
