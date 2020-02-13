package oop.acdpsp.ch10isp;

/** A simple interface for CRUD operations on an entity. */
public interface CreateReadUpdateDelete<E> {
    void create(E entity);

    E readOne(long id);

    Iterable<E> readAll();

    void update(E entity);

    void delete(E entity);
}
