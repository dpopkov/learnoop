package learn.oop.jpdppp.examples.mvcjavafx;

import java.util.ArrayList;
import java.util.Collection;

public class CountModel {
    private final Collection<CountObserver> observers = new ArrayList<>();
    private int count = 0;

    public void addObserver(CountObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(int count) {
        for (CountObserver obs : observers) {
            obs.update(count);
        }
    }

    public void updateBy(int n) {
        count += n;
        notifyObservers(count);
    }

    public int getCount() {
        return count;
    }
}
