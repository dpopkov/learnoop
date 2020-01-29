package learn.oop.acdpsp.ch04interf.nullobj;

public class RegularUser implements User {
    private int id;
    private int value;

    public RegularUser(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void incrementValue() {
        value++;
    }

    @Override
    public String toString() {
        return "RegularUser{id=" + id + ", value=" + value + '}';
    }
}
