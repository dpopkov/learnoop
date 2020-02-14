package oop.acdpsp.ch10isp.multiple;

import oop.acdpsp.ch10isp.Delete;

/**
 * This decorator publishes an event whenever en entity is deleted.
 * @param <E> type of entity
 */
public class DeleteEventPublishing<E> implements Delete<E> {
    private Delete<E> decorated;
    private EventPublisher<E> eventPublisher;

    public DeleteEventPublishing(Delete<E> decorated, EventPublisher<E> eventPublisher) {
        this.decorated = decorated;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void delete(E entity) {
        decorated.delete(entity);
        var entityDeleted = new EntityDeletedEvent<>(entity);
        eventPublisher.publish(entityDeleted);
    }
}
