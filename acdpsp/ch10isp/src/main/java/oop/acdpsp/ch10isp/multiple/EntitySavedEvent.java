package oop.acdpsp.ch10isp.multiple;

public class EntitySavedEvent<E> extends Event<E> {
    private E savedEntity;

    public EntitySavedEvent(E entity) {
        super("EntitySaved");
        savedEntity = entity;
    }
}
