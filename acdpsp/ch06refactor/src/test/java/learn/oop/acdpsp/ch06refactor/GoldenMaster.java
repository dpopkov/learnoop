package learn.oop.acdpsp.ch06refactor;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map;

import static learn.oop.acdpsp.ch06refactor.CharacterizationTestsGenerator.CHARACTERIZATION_TESTS_DIR;

/**
 * This test takes the outputs of the characterization tests and uses them as expectations to assert against.
 * It is not, strictly speaking, unit test, because it depends on externality such as the filesystem.
 */
public class GoldenMaster {
    private static final Map<String, String> inputsAndExpectations = Map.of(
            "empty-file.txt", "expectations-empty-file.txt",
            "one-field.txt", "expectations-one-field.txt",
            "malformed-currency-pair.txt", "expectations-malformed-currency-pair.txt",
            "trade-volume-invalid.txt", "expectations-trade-volume-invalid.txt",
            "trade-amount-invalid.txt", "expectations-trade-amount-invalid.txt",
            "correct-format.txt", "expectations-correct-format.txt"
    );

    @Test
    public void outputStillMatchesCharacterization() throws IOException, SQLException {
        PrintStream originalOut = System.out;
        for (Map.Entry<String, String> me : inputsAndExpectations.entrySet()) {
            Path inputPath = Paths.get(CHARACTERIZATION_TESTS_DIR, me.getKey());
            Path expectationPath = Paths.get(CHARACTERIZATION_TESTS_DIR, me.getValue());
            String actual;
            String expectation = Files.readString(expectationPath);
            try (InputStream input = Files.newInputStream(inputPath)) {
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                System.setOut(new PrintStream(buffer));
                TradeProcessor tradeProcessor = new TradeProcessor();
                tradeProcessor.processTrades(input);
                actual = buffer.toString();
            }
            Assert.assertEquals(expectation, actual);
        }
        System.setOut(originalOut);
    }
}
