package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeRecord;

import java.math.BigDecimal;

public class SimpleTradeMapper implements TradeMapper {
    private final int lotSize;

    public SimpleTradeMapper(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public TradeRecord map(String[] data) {
        String sourceCurrencyCode = data[0].substring(0, 3);
        String destinationCurrencyCode = data[0].substring(3);
        int tradeAmount = Integer.parseInt(data[1]);
        int lots = tradeAmount / lotSize;
        BigDecimal price = new BigDecimal(data[2]);
        return new TradeRecord(sourceCurrencyCode, destinationCurrencyCode, lots, price);
    }
}
