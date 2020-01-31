package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeParser;
import learn.oop.acdpsp.ch06refactor.TradeStorage;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * This test takes the outputs of the characterization tests and uses them as expectations to assert against.
 * It is not, strictly speaking, unit test, because it depends on externality such as the filesystem.
 */
public class GoldenMaster2 {
    private static final String CHARACTERIZATION_TESTS_DIR = "txt";
    private static final Map<String, String> inputsAndExpectations = Map.of(
            "empty-file.txt", "expectations-empty-file.txt",
            "one-field.txt", "expectations-one-field.txt",
            "malformed-currency-pair.txt", "expectations-malformed-currency-pair.txt",
            "trade-volume-invalid.txt", "expectations-trade-volume-invalid.txt",
            "trade-amount-invalid.txt", "expectations-trade-amount-invalid.txt",
            "correct-format.txt", "expectations-correct-format.txt"
    );
    private static Connection connection;
    private static TradeParser parser;
    private static TradeStorage storage;

    @BeforeClass
    public static void setupConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
        createTable(connection);
        storage = new JDBCTradeStorage(connection);
        parser = new SimpleTradeParser(new SimpleTradeValidator(), new SimpleTradeMapper(TradeProcessor2.LOT_SIZE));
    }

    @Test
    public void outputStillMatchesCharacterization() throws IOException, SQLException {
        PrintStream originalOut = System.out;
        TradeProcessor2 tradeProcessor = new TradeProcessor2(parser, storage);
        for (Map.Entry<String, String> me : inputsAndExpectations.entrySet()) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buffer));
            try (InputStream input = Files.newInputStream(getPath(me.getKey()))) {
                tradeProcessor.setDataProvider(new InputStreamDataProvider(input));
                tradeProcessor.processTrades();
            }
            Assert.assertEquals(Files.readString(getPath(me.getValue())), buffer.toString());
        }
        System.setOut(originalOut);
    }

    @AfterClass
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("CREATE TABLE trade ("
                + "sourcecurrency char(3),"
                + "destinationcurrency char(3),"
                + "lots int,"
                + "price decimal"
                + ")");
    }

    private static Path getPath(String filename) {
        return Paths.get(CHARACTERIZATION_TESTS_DIR, filename);
    }
}
