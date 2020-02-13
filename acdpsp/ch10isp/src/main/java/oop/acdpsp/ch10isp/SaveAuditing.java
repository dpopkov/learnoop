package oop.acdpsp.ch10isp;

import java.time.LocalDateTime;

public class SaveAuditing<E> implements Save<E> {
    private Save<E> decorated;
    private Save<AuditInfo> auditSave;

    public SaveAuditing(Save<E> decorated, Save<AuditInfo> auditSave) {
        this.decorated = decorated;
        this.auditSave = auditSave;
    }

    @Override
    public void save(E entity) {
        decorated.save(entity);
        var auditInfo = new AuditInfo(Thread.currentThread().getName(), LocalDateTime.now());
        auditSave.save(auditInfo);
    }
}
