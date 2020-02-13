package oop.acdpsp.ch10isp;

public class CrudTransactional <E> implements CreateReadUpdateDelete<E> {
    private CreateReadUpdateDelete<E> decoratedCrud;

    @Override
    public void create(E entity) {
        try (var transaction = new TransactionScope()) {
            decoratedCrud.create(entity);
            transaction.commit();
        }
    }

    @Override
    public E readOne(long id) {
        E entity;
        try (var transaction = new TransactionScope()) {
            entity = decoratedCrud.readOne(id);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public Iterable<E> readAll() {
        Iterable<E> result;
        try (var transaction = new TransactionScope()) {
            result = decoratedCrud.readAll();
            transaction.commit();
        }
        return result;
    }

    @Override
    public void update(E entity) {
        try (var transaction = new TransactionScope()) {
            decoratedCrud.update(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(E entity) {
        try (var transaction = new TransactionScope()) {
            decoratedCrud.delete(entity);
            transaction.commit();
        }
    }
}
