package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeRecord;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static learn.oop.acdpsp.ch07srp.JDBCTradeStorage.INSERT_SQL;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JDBCTradeStorageTest {
    private final Connection conn = mock(Connection.class);
    private final PreparedStatement stmt = mock(PreparedStatement.class);

    @Test
    public void testPersist() throws SQLException {
        when(conn.prepareStatement(INSERT_SQL)).thenReturn(stmt);
        when(stmt.executeUpdate()).thenReturn(1);
        var trades = List.of(
                new TradeRecord("s1", "d1", 2, BigDecimal.valueOf(3.4)),
                new TradeRecord("s2", "d2", 5, BigDecimal.valueOf(6.7))
        );
        JDBCTradeStorage storage = new JDBCTradeStorage(conn);
        int count = storage.persist(trades);
        assertEquals(2, count);
        verify(conn).prepareStatement(INSERT_SQL);
        verify(stmt, times(2)).executeUpdate();
    }
}
