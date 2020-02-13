package oop.acdpsp.ch10isp;

/** A simple interface for CRUD operations on an entity. */
public interface SaveReadDelete<E> extends Save<E>, Read<E>, Delete<E> {
}
