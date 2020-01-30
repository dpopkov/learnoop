package learn.oop.acdpsp.ch06refactor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDb {
    public static void main(String[] args) throws SQLException {
        final String createSql = "CREATE TABLE trade ("
                + "sourcecurrency char(3),"
                + "destinationcurrency char(3),"
                + "lots int,"
                + "price decimal"
                + ")";
        try (Connection conn = JDBCHelper.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(createSql);
            System.out.println("Table trade created.");
        }
    }
}
