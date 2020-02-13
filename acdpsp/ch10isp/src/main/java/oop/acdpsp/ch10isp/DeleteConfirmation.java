package oop.acdpsp.ch10isp;

/** Decorates only the delete method. */
public class DeleteConfirmation<E> implements Delete<E> {
    private final SaveReadDelete<E> decoratedCrud;
    private final UserInteraction userInteraction;

    public DeleteConfirmation(SaveReadDelete<E> decoratedCrud, UserInteraction userInteraction) {
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
