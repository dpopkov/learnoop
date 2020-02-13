package oop.acdpsp.ch10isp;

import java.util.Scanner;

/** Decorates only the delete method. */
public class DeleteConfirmation<E> implements Delete<E> {
    private final CreateReadUpdateDelete<E> decoratedCrud;
    private final UserInteraction userInteraction;

    public DeleteConfirmation(CreateReadUpdateDelete<E> decoratedCrud, UserInteraction userInteraction) {
        this.decoratedCrud = decoratedCrud;
        this.userInteraction = userInteraction;
    }

    @Override
    public void delete(E entity) {
        if (userInteraction.confirm("Are you sue you want to delete the entity? [y/n] ")) {
            decoratedCrud.delete(entity);
        }
    }
}
