package learn.oop.acdpsp.ch07srp;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class SimpleTradeValidatorTest {
    private final SimpleTradeValidator validator = new SimpleTradeValidator();

    @Test
    public void validateDataLength() {
        String[] data = {"a", "b"};
        assertFalse(validator.validate(data, 1));
    }

    @Test
    public void validateCurrencies() {
        String[] data = {"abcd", "e", "f"};
        assertFalse(validator.validate(data, 1));
    }

    @Test
    public void validateTradeAmount() {
        String[] data = {"abcdef", "abc", "f"};
        assertFalse(validator.validate(data, 1));
    }

    @Test
    public void validateTradePrice() {
        String[] data = {"abcdef", "200", "f"};
        assertFalse(validator.validate(data, 1));
    }

    @Test
    public void validateCorrectData() {
        String[] data = {"abcdef", "200", "10.02"};
        assertTrue(validator.validate(data, 1));
    }
}
