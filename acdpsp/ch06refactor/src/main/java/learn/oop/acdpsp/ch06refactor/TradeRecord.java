package learn.oop.acdpsp.ch06refactor;

import java.math.BigDecimal;

public class TradeRecord {
    private final String sourceCurrencyCode;
    private final String destinationCurrencyCode;
    private final int lots;
    private final BigDecimal price;

    public TradeRecord(String sourceCurrencyCode, String destinationCurrencyCode, int lots, BigDecimal price) {
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.destinationCurrencyCode = destinationCurrencyCode;
        this.lots = lots;
        this.price = price;
    }

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    public String getDestinationCurrencyCode() {
        return destinationCurrencyCode;
    }

    public int getLots() {
        return lots;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
