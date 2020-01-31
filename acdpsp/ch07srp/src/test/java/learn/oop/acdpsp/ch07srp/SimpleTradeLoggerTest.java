package learn.oop.acdpsp.ch07srp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTradeLoggerTest {
    private final SimpleTradeLogger logger = SimpleTradeLogger.getInstance();

    @Test
    public void testReformat() {
        String message = "string: {} int: {}";
        String expected = "string: %s int: %d";
        assertEquals(expected, logger.reformat(message, "42", 42));
    }
}
