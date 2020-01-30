package learn.oop.acdpsp.ch06refactor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

/**
 * Generates characterization tests as the SUT's (System Under Test) stored current behaviour.
 */
public class CharacterizationTestsGenerator {

    public static final String CHARACTERIZATION_TESTS_DIR = "txt";

    public static void main(String[] args) throws IOException, SQLException {
        List<String> inputs = List.of(
                "empty-file.txt",
                "one-field.txt",
                "malformed-currency-pair.txt",
                "trade-volume-invalid.txt",
                "trade-amount-invalid.txt",
                "correct-format.txt"
        );
        PrintStream originalOut = System.out;
        for (String input : inputs) {
            Path inputPath = Paths.get(CHARACTERIZATION_TESTS_DIR, input);
            Path outPath = Paths.get(CHARACTERIZATION_TESTS_DIR, "expectations-" + input);
            try (InputStream tradeStream = Files.newInputStream(inputPath);
                 OutputStream outStream = Files.newOutputStream(outPath)
            ) {
                TradeProcessor tradeProcessor = new TradeProcessor();
                System.setOut(new PrintStream(outStream));
                tradeProcessor.processTrades(tradeStream);
            }
        }
        System.setOut(originalOut);
        System.out.println("CharacterizationTesting finished");
    }
}
