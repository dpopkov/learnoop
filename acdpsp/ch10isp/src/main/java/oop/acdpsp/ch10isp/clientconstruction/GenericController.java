package oop.acdpsp.ch10isp.clientconstruction;

import oop.acdpsp.ch10isp.Delete;
import oop.acdpsp.ch10isp.Read;
import oop.acdpsp.ch10isp.Save;

public class GenericController<E> {
    private Read<E> reader;
    private Save<E> saver;
    private Delete<E> deleter;

    public GenericController(Read<E> reader, Save<E> saver, Delete<E> deleter) {
        this.reader = reader;
        this.saver = saver;
        this.deleter = deleter;
    }

    public void createEntity(E entity) {
        saver.save(entity);
    }

    public E getSingleEntity(long id) {
        return reader.readOne(id);
    }

    public void updateOrder(E entity) {
        saver.save(entity);
    }

    public void deleteOrder(E entity) {
        deleter.delete(entity);
    }
}
