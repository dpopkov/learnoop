package learn.oop.springdp.springdp.adapter;

public class AppleAdapter implements Apple {

    private final Orange orange;

    public AppleAdapter(Orange orange) {
        this.orange = orange;
    }

    @Override
    public String getVariety() {
        return orange.getVariety();
    }

    @Override
    public String eat() {
        return orange.peel() + ", " + orange.eat();
    }
}
