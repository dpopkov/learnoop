package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeRecord;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class SimpleTradeMapperTest {

    @Test
    public void testMap() {
        SimpleTradeMapper mapper = new SimpleTradeMapper(5);
        String[] data = {"abcefg", "100", "20.3"};
        TradeRecord actual = mapper.map(data);
        assertThat(actual, is(new TradeRecord("abc", "efg",
                20, BigDecimal.valueOf(20.3))));
    }
}
