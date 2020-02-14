package oop.acdpsp.ch10isp.multiple;

public class EntityDeletedEvent<E> extends Event<E> {
    private E deletedEntity;

    public EntityDeletedEvent(E deletedEntity) {
        super("EntityDeleted");
        this.deletedEntity = deletedEntity;
    }

    public E getDeletedEntity() {
        return deletedEntity;
    }
}
