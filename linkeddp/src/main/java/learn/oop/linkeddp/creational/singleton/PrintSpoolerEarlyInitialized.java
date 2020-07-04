package learn.oop.linkeddp.creational.singleton;

public class PrintSpoolerEarlyInitialized {
    private static final PrintSpoolerEarlyInitialized spooler = new PrintSpoolerEarlyInitialized();

    private PrintSpoolerEarlyInitialized() {
        init();
    }

    private void init() {
        // code to initialize our print spooler goes here
    }

    public static PrintSpoolerEarlyInitialized getInstance() {
        return spooler;
    }
}
