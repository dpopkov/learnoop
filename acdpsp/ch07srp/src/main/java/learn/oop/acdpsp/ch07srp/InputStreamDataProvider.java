package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeDataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputStreamDataProvider implements TradeDataProvider {
    private final InputStream inputStream;

    public InputStreamDataProvider(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public Iterable<String> getTradeData() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
