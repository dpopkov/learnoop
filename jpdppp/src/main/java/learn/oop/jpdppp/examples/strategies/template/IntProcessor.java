package learn.oop.jpdppp.examples.strategies.template;

public abstract class IntProcessor {
    public void operateOn(int x) {
        int y = f(x);
        System.out.println(x + " becomes " + y);
    }

    protected abstract int f(int x);
}
