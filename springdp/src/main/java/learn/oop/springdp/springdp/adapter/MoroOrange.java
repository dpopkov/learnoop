package learn.oop.springdp.springdp.adapter;

public class MoroOrange implements Orange {
    @Override
    public String getVariety() {
        return "Moro Blood Orange";
    }

    @Override
    public String eat() {
        return "Moro gets enjoyed";
    }

    @Override
    public String peel() {
        return "Moro gets peeled";
    }

    @Override
    public String juice() {
        return "Moro gets juiced";
    }
}
