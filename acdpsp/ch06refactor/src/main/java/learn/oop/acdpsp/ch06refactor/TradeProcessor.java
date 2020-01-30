package learn.oop.acdpsp.ch06refactor;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TradeProcessor {
    private static final int LOT_SIZE = 100_000;

    private Optional<Integer> tradeAmountOptional;
    private Optional<BigDecimal> tradePriceOptional;

    public void processTrades(InputStream stream) throws IOException, SQLException {
        List<String> lines = readLines(stream);
        List<TradeRecord> trades = parseTrades(lines);
        storeTrades(trades);
    }

    private void storeTrades(List<TradeRecord> trades) throws SQLException {
        if (trades.size() > 0) {
            try (Connection conn = JDBCHelper.getConnection()) {
                conn.setAutoCommit(false);
                String insertSql = "INSERT INTO trade (sourcecurrency, destinationcurrency, lots, price) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(insertSql);
                for (TradeRecord trade : trades) {
                    stmt.setString(1, trade.getSourceCurrencyCode());
                    stmt.setString(2, trade.getDestinationCurrencyCode());
                    stmt.setInt(3, trade.getLots());
                    stmt.setBigDecimal(4, trade.getPrice());
                    stmt.executeUpdate();
                }
                conn.commit();
            }
        }
        logMessage("INFO: %d trades processed%n", trades.size());
    }

    private List<TradeRecord> parseTrades(List<String> lines) {
        List<TradeRecord> trades = new ArrayList<>();
        int lineCount = 1;
        for (String line : lines) {
            String[] fields = line.split(",");
            if (!validateTradeFields(fields, lineCount)) {
                continue;
            }
            String sourceCurrencyCode = fields[0].substring(0, 3);
            String destinationCurrencyCode = fields[0].substring(3);
            int lots = tradeAmountOptional.orElse(0) / LOT_SIZE;
            BigDecimal price = tradePriceOptional.orElse(BigDecimal.ZERO);
            TradeRecord trade = new TradeRecord(sourceCurrencyCode, destinationCurrencyCode, lots, price);
            trades.add(trade);
            lineCount++;
        }
        return trades;
    }

    private boolean validateTradeFields(String[] fields, int lineCount) {
        if (fields.length != 3) {
            logMessage("WARN: %s malformed. Only %d field(s) found.%n", lineCount, fields.length);
            return false;
        }
        if (fields[0].length() != 6) {
            logMessage("WARN: Trade currencies on line %d malformed: '%s'%n", lineCount, fields[0]);
            return false;
        }
        if ((tradeAmountOptional = tryParseInteger(fields[1])).isEmpty()) {
            logMessage("WARN: Trade amount on line %d not a valid integer: '%s'%n", lineCount, fields[1]);
        }
        if ((tradePriceOptional = tryParseDecimal(fields[2])).isEmpty()) {
            logMessage("WARN: Trade price on line %d not a valid decimal: '%s'%n", lineCount, fields[2]);
        }
        return true;
    }

    private void logMessage(String format, Object... args) {
        System.out.printf(format, args);
    }

    private List<String> readLines(InputStream stream) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static Optional<Integer> tryParseInteger(String intStr) {
        try {
            Integer value = Integer.valueOf(intStr);
            return Optional.of(value);
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }

    private static Optional<BigDecimal> tryParseDecimal(String decimalStr) {
        try {
            BigDecimal value = new BigDecimal(decimalStr);
            return Optional.of(value);
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }
}
