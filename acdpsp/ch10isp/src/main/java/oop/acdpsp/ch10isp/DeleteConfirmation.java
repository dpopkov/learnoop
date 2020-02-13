package oop.acdpsp.ch10isp;

import java.util.Scanner;

/** Decorates only the delete method. */
public class DeleteConfirmation<E> implements CreateReadUpdateDelete<E> {
    private final CreateReadUpdateDelete<E> decoratedCrud;

    public DeleteConfirmation(CreateReadUpdateDelete<E> decoratedCrud) {
        this.decoratedCrud = decoratedCrud;
    }

    @Override
    public void create(E entity) {
        decoratedCrud.create(entity);
    }

    @Override
    public E readOne(long id) {
        return decoratedCrud.readOne(id);
    }

    @Override
    public Iterable<E> readAll() {
        return decoratedCrud.readAll();
    }

    @Override
    public void update(E entity) {
        decoratedCrud.update(entity);
    }

    @Override
    public void delete(E entity) {
        Scanner in = new Scanner(System.in);
        System.out.print("Are you sue you want to delete the entity? [y/n] ");
        String key = in.nextLine();
        if ("y".equalsIgnoreCase(key)) {
            decoratedCrud.delete(entity);
        }
    }
}
