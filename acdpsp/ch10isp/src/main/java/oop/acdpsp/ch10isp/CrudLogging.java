package oop.acdpsp.ch10isp;

import org.apache.logging.log4j.Logger;

public class CrudLogging <E> implements SaveReadDelete<E> {
    private SaveReadDelete<E> decoratedCrud;
    private Class<E> eClass;
    private Logger log;

    public CrudLogging(SaveReadDelete<E> decoratedCrud, Class<E> eClass, Logger log) {
        this.decoratedCrud = decoratedCrud;
        this.eClass = eClass;
        this.log = log;
    }

    @Override
    public void save(E entity) {
        log.info("Saving entity of type {}", entity.getClass().getName());
        decoratedCrud.save(entity);
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
    public void delete(E entity) {
        log.info("Deleting entity of type {}", entity.getClass().getName());
        decoratedCrud.delete(entity);
    }
}
