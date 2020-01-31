package learn.oop.acdpsp.ch06refactor;

import java.sql.SQLException;

public interface TradeStorage {
    int persist(Iterable<TradeRecord> trades) throws SQLException;
}
