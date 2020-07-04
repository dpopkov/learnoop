package learn.oop.linkeddp.creational.singleton;

public class ResourceManager {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                PrintSpooler ps = PrintSpooler.getInstance();
                System.out.println(ps);
            });
            thread.start();
        }
    }
}
