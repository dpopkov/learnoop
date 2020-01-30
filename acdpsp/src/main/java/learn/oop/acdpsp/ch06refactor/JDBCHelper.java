package learn.oop.acdpsp.ch06refactor;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCHelper {
    public static final String BASE_URL = "jdbc:h2:";
    public static final String DB_NAME = "trade_processor";
    public static final String DB_DIRECTORY = "db";
    public static final String DB_URL = BASE_URL + getAbsolutePathInCurrentWorkingDirectory(DB_NAME);
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "";

    private static String getAbsolutePathInCurrentWorkingDirectory(String dbName) {
        return System.getProperty("user.dir") + File.separator + DB_DIRECTORY + File.separator + dbName;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
