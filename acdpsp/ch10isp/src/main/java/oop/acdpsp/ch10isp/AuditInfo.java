package oop.acdpsp.ch10isp;

import java.time.LocalDateTime;

public class AuditInfo {
    private final String userName;
    private final LocalDateTime timeStamp;

    public AuditInfo(String userName, LocalDateTime timeStamp) {
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
