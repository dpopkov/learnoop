package learn.oop.acdpsp.ch06refactor;

import java.io.IOException;

public interface TradeDataProvider {
    Iterable<String> getTradeData() throws IOException;
}
