package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeParser;
import learn.oop.acdpsp.ch06refactor.TradeRecord;

import java.util.ArrayList;
import java.util.List;

public class SimpleTradeParser implements TradeParser {
    private final TradeValidator validator;
    private final TradeMapper mapper;

    public SimpleTradeParser(TradeValidator validator, TradeMapper mapper) {
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public Iterable<TradeRecord> parse(Iterable<String> tradeData) {
        List<TradeRecord> trades = new ArrayList<>();
        int lineCount = 1;
        for (String line : tradeData) {
            String[] fields = line.split(",");
            if (validator.validate(fields, lineCount)) {
                TradeRecord trade = mapper.map(fields);
                trades.add(trade);
                lineCount++;
            }
        }
        return trades;
    }
}
