package learn.oop.acdpsp.ch06refactor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCHelper {
    public static final String BASE_URL = "jdbc:h2:";
    public static final String IN_MEMORY_URL = "jdbc:h2:mem:";
    public static final String DB_NAME = "trade_processor";
    public static final String MODULE_DIRECTORY = "ch06refactor";
    public static final String DB_DIRECTORY = "db";
    public static final String DB_URL = BASE_URL + getAbsolutePathInCurrentWorkingDirectory(DB_NAME);
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "";

    private static boolean useMemory = false;
    static {
        try {
            try (InputStream in = JDBCHelper.class.getResourceAsStream("/app.properties")) {
                Properties props = new Properties();
                props.load(in);
                if (props.getProperty("connection-type").equals("memory")) {
                    useMemory = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getAbsolutePathInCurrentWorkingDirectory(String dbName) {
        String path = System.getProperty("user.dir");
        if (!path.endsWith(MODULE_DIRECTORY)) {
            path += File.separator + MODULE_DIRECTORY;
        }
        path += File.separator + DB_DIRECTORY + File.separator + dbName;
        return path;
    }

    public static Connection getConnection() throws SQLException {
        Connection connection;
        if (useMemory) {
            connection = getInMemoryConnection();
        } else {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }

    public static Connection getInMemoryConnection() throws SQLException {
        return DriverManager.getConnection(IN_MEMORY_URL, DB_USER, DB_PASSWORD);
    }

    public static void main(String[] args) {
        System.out.println(getAbsolutePathInCurrentWorkingDirectory(DB_NAME));
    }
}
