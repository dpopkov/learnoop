package oop.acdpsp.ch10isp.multiple;

import oop.acdpsp.ch10isp.Delete;
import oop.acdpsp.ch10isp.Save;

public class ModificationEventPublishing<E> implements Delete<E>, Save<E> {
    private Delete<E> decoratedDelete;
    private Save<E> decoratedSave;
    private EventPublisher<E> eventPublisher;

    public ModificationEventPublishing(Delete<E> decoratedDelete, Save<E> decoratedSave, EventPublisher<E> eventPublisher) {
        this.decoratedDelete = decoratedDelete;
        this.decoratedSave = decoratedSave;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void delete(E entity) {
        decoratedDelete.delete(entity);
        var entityDeleted = new EntityDeletedEvent<>(entity);
        eventPublisher.publish(entityDeleted);
    }

    @Override
    public void save(E entity) {
        decoratedSave.save(entity);
        var entitySaved = new EntitySavedEvent<>(entity);
        eventPublisher.publish(entitySaved);
    }
}
