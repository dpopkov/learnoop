package learn.oop.acdpsp.ch07srp;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class SimpleTradeValidator implements TradeValidator {
//    private static final Logger LOG = LogManager.getLogger(SimpleTradeValidator.class);
    private static final SimpleTradeLogger LOG = SimpleTradeLogger.getInstance();
    private final Pattern intPattern = Pattern.compile("\\d+");
    private final Pattern decimalPattern = Pattern.compile("\\d+\\.\\d+");

    @Override
    public boolean validate(String[] data, int lineNumber) {
        if (data.length != 3) {
            LOG.warn("{} malformed. Only {} field(s) found.", lineNumber, data.length);
            return false;
        }
        if (data[0].length() != 6) {
            LOG.warn("Trade currencies on line {} malformed: '{}'", lineNumber, data[0]);
            return false;
        }
        if (!intPattern.matcher(data[1]).matches()) {
            LOG.warn("Trade amount on line {} not a valid integer: '{}'", lineNumber, data[1]);
            return false;
        }
        if (!decimalPattern.matcher(data[2]).matches()) {
            LOG.warn("Trade price on line {} not a valid decimal: '{}'", lineNumber, data[2]);
            return false;
        }
        return true;
    }
}
