package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeRecord;
import learn.oop.acdpsp.ch06refactor.TradeStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class JDBCTradeStorage implements TradeStorage {
//    private static final Logger LOG = LogManager.getLogger(JDBCTradeStorage.class);
    private static final SimpleTradeLogger LOG = SimpleTradeLogger.getInstance();
    static final String INSERT_SQL =
            "INSERT INTO trade (sourcecurrency, destinationcurrency, lots, price) VALUES (?, ?, ?, ?)";
    private final Connection connection;

    public JDBCTradeStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int persist(Iterable<TradeRecord> trades) throws SQLException {
        int count = 0;
        connection.setAutoCommit(false);
        PreparedStatement stmt = connection.prepareStatement(INSERT_SQL);
        for (TradeRecord trade : trades) {
            stmt.setString(1, trade.getSourceCurrencyCode());
            stmt.setString(2, trade.getDestinationCurrencyCode());
            stmt.setInt(3, trade.getLots());
            stmt.setBigDecimal(4, trade.getPrice());
            if (stmt.executeUpdate() == 1) {
                count++;
            }
        }
        connection.commit();
        LOG.info("{} trades processed", count);
        return count;
    }
}
