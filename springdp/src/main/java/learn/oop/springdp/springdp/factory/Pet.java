package learn.oop.springdp.springdp.factory;

public interface Pet {

    void setName(String name);
    String getName();
    String getType();
    boolean isHungry();
    void feed();
}
