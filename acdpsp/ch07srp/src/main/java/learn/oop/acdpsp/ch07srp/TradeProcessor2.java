package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeDataProvider;
import learn.oop.acdpsp.ch06refactor.TradeParser;
import learn.oop.acdpsp.ch06refactor.TradeRecord;
import learn.oop.acdpsp.ch06refactor.TradeStorage;

import java.io.IOException;
import java.sql.SQLException;

public class TradeProcessor2 {
    static final int LOT_SIZE = 100_000;

    private final TradeParser tradeParser;
    private final TradeStorage tradeStorage;
    private TradeDataProvider dataProvider;

    public TradeProcessor2(TradeParser tradeParser, TradeStorage tradeStorage) {
        this.tradeParser = tradeParser;
        this.tradeStorage = tradeStorage;
    }

    public void processTrades() throws IOException, SQLException {
        if (dataProvider == null) {
            throw new IllegalStateException("Data provider is not set");
        }
        Iterable<String> data = dataProvider.getTradeData();
        Iterable<TradeRecord> trades = tradeParser.parse(data);
        tradeStorage.persist(trades);
    }

    public void setDataProvider(TradeDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
}
