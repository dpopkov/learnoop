package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeRecord;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleTradeParserTest {

    @Test
    public void whenParseValidFieldsThenAddToResult() {
        SimpleTradeParser parser = new SimpleTradeParser((data, number) -> true,
                data -> new TradeRecord(data[0], data[1], Integer.parseInt(data[2]), new BigDecimal(data[3])));
        Iterable<TradeRecord> actual = parser.parse(List.of("SRC,DST,100,200.2"));
        assertThat(actual.iterator().next(), Matchers.is(new TradeRecord("SRC", "DST",
                100, BigDecimal.valueOf(200.2))));
    }
}
