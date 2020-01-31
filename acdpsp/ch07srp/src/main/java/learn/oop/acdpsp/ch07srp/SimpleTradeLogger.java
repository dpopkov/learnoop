package learn.oop.acdpsp.ch07srp;

public class SimpleTradeLogger {
    private static final SimpleTradeLogger instance = new SimpleTradeLogger();

    public static SimpleTradeLogger getInstance() {
        return instance;
    }

    private SimpleTradeLogger() {
    }

    public void warn(String message, Object... args) {
        String format = reformat(message, args);
        System.out.printf("WARN: " + format + "%n", args);
    }

    public void info(String message, Object... args) {
        String format = reformat(message, args);
        System.out.printf("INFO: " + format + "%n", args);
    }

    String reformat(String message, Object... args) {
        int idx = 0;
        while (message.contains("{}")) {
            Object arg = args[idx];
            String replacement = "%s";
            if (arg instanceof Integer) {
                replacement = "%d";
            }
            message = message.replaceFirst("\\{}", replacement);
            idx++;
        }
        return message;
    }
}
