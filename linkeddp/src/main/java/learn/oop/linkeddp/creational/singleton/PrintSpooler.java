package learn.oop.linkeddp.creational.singleton;

public class PrintSpooler {
    private static PrintSpooler spooler;

    private static boolean initialized = false;

    private PrintSpooler() {
    }

    private void init() {
        // code to initialize our print spooler goes here
    }

    public static PrintSpooler getInstance() {
        if (initialized) {
            return spooler;
        }
        try {
            Thread.sleep(10L);      // Allows other threads to come in to show the problem
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        spooler = new PrintSpooler();
        spooler.init();
        initialized = true;
        return spooler;
    }
}
