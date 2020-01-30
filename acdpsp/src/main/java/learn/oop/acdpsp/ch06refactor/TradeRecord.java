package learn.oop.acdpsp.ch06refactor;

import java.math.BigDecimal;

public class TradeRecord {
    private String sourceCurrencyCode;
    private String destinationCurrencyCode;
    private int lots;
    private BigDecimal price;

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
