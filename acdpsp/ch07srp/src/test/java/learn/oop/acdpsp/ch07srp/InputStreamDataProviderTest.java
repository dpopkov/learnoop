package learn.oop.acdpsp.ch07srp;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class InputStreamDataProviderTest {

    @Test
    public void whenGetTradeDataThenReturnsLines() throws IOException {
        byte[] bytes = ("line1" + System.lineSeparator() + "line2").getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        InputStreamDataProvider provider = new InputStreamDataProvider(inputStream);
        Iterable<String> actual = provider.getTradeData();
        assertThat(actual, hasItems("line1", "line2"));
    }
}
