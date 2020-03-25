package learn.oop.jpdppp.examples.mvcjavafx;

public class WatcherController implements CountObserver {
    private WatcherView view;
    private int howMany = 0;

    public WatcherController(CountModel model) {
        model.addObserver(this);
    }

    public void setView(WatcherView view) {
        this.view = view;
    }

    @Override
    public void update(int count) {
        howMany++;
        boolean even = (count % 2) == 0;
        boolean odd = !even;
        String msg = "The count has changed " + howMany + " times";
        view.updateDisplay(msg, even, odd);
    }
}
