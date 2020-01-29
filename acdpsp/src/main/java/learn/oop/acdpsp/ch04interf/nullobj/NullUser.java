package learn.oop.acdpsp.ch04interf.nullobj;

public class NullUser implements User {
    public static final User instance = new NullUser();

    public static User get() {
        return instance;
    }

    private NullUser() {}

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public int getValue() {
        return -1;
    }

    @Override
    public void incrementValue() {
        // does nothing
    }

    @Override
    public String toString() {
        return "NullUser{}";
    }
}
