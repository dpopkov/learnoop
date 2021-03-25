package learn.oop.springdp.springdp.factory;

public class Cat extends BasePet implements Pet {

    @Override
    public String getType() {
        return "cat";
    }

    @Override
    public boolean isHungry() {
        return false;
    }

    @Override
    public void feed() {
        System.out.println("Feeding the cat named " + getName());
    }
}
