package oop.acdpsp.ch10isp;

/** A simple interface for CRUD operations on an entity. */
public interface CreateReadUpdateDelete<E> extends CreateReadUpdate<E>, Delete<E> {
}
