package oop.acdpsp.ch10isp;

import java.util.HashMap;
import java.util.Map;

public class ReadCaching<E> implements Read<E> {
    private final Read<E> decorated;
    private E cachedEntity;
    private Map<Long, E> cachedEntities = new HashMap<>();
    private Iterable<E> allCachedEntities;

    public ReadCaching(Read<E> decorated) {
        this.decorated = decorated;
    }

    @Override
    public E readOne(long id) {
        E foundEntity = cachedEntities.get(id);
        if (foundEntity == null) {
            foundEntity = decorated.readOne(id);
            if (foundEntity != null) {
                cachedEntities.put(id, foundEntity);
            }
        }
        return foundEntity;
    }

    @Override
    public Iterable<E> readAll() {
        if (allCachedEntities == null) {
            allCachedEntities = decorated.readAll();
        }
        return allCachedEntities;
    }
}
