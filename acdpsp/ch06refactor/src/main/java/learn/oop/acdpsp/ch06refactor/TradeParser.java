package learn.oop.acdpsp.ch06refactor;

public interface TradeParser {
    Iterable<TradeRecord> parse(Iterable<String> tradeData);
}
