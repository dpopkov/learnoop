package oop.acdpsp.ch10isp;

import org.apache.logging.log4j.Logger;

public class CrudLogging <E> implements CreateReadUpdateDelete<E> {
    private CreateReadUpdateDelete<E> decoratedCrud;
    private Class<E> eClass;
    private Logger log;

    public CrudLogging(CreateReadUpdateDelete<E> decoratedCrud, Class<E> eClass, Logger log) {
        this.decoratedCrud = decoratedCrud;
        this.eClass = eClass;
        this.log = log;
    }

    @Override
    public void create(E entity) {
        log.info("Creating entity of type {}", entity.getClass().getName());
        decoratedCrud.create(entity);
    }

    @Override
    public E readOne(long id) {
        log.info("Reading entity of type {} with id {}", eClass.getName(), id);
        return decoratedCrud.readOne(id);
    }

    @Override
    public Iterable<E> readAll() {
        log.info("Reading all entities of type {}", eClass.getName());
        return decoratedCrud.readAll();
    }

    @Override
    public void update(E entity) {
        log.info("Updating entity of type {}", entity.getClass().getName());
        decoratedCrud.update(entity);
    }

    @Override
    public void delete(E entity) {
        log.info("Deleting entity of type {}", entity.getClass().getName());
        decoratedCrud.delete(entity);
    }
}
