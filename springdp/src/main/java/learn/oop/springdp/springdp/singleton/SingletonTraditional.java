package learn.oop.springdp.springdp.singleton;

public class SingletonTraditional {
    private static volatile SingletonTraditional instance;

    private SingletonTraditional() {
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static SingletonTraditional getInstance() {
        if (instance == null) {
            synchronized (SingletonTraditional.class) {
                if (instance == null) {
                    instance = new SingletonTraditional();
                }
            }
        }
        return instance;
    }
}
