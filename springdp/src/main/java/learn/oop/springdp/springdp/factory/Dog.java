package learn.oop.springdp.springdp.factory;

public class Dog extends BasePet implements Pet {

    @Override
    public String getType() {
        return "dog";
    }

    @Override
    public boolean isHungry() {
        return false;
    }

    @Override
    public void feed() {
        System.out.println("Feeding the dog named " + getName());
    }
}
