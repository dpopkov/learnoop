package learn.oop.acdpsp.ch06refactor;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeRecord that = (TradeRecord) o;
        return lots == that.lots &&
                Objects.equals(sourceCurrencyCode, that.sourceCurrencyCode) &&
                Objects.equals(destinationCurrencyCode, that.destinationCurrencyCode) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceCurrencyCode, destinationCurrencyCode, lots, price);
    }

    @Override
    public String toString() {
        return "TradeRecord{sourceCurrencyCode='" + sourceCurrencyCode + '\''
                + ", destinationCurrencyCode='" + destinationCurrencyCode + '\''
                + ", lots=" + lots + ", price=" + price + '}';
    }
}
