package learn.oop.acdpsp.ch06refactor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDb {
    private static final String CREATE_SQL = "CREATE TABLE trade ("
            + "sourcecurrency char(3),"
            + "destinationcurrency char(3),"
            + "lots int,"
            + "price decimal"
            + ")";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = JDBCHelper.getConnection()) {
            createTable(conn);
        }
    }

    public static void createTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(CREATE_SQL);
        System.out.println("Table trade created.");
    }
}
