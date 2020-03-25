package learn.oop.jpdppp.examples.mvcjavafx;

/**
 * This controller is responsible for translating events on a view into actions on a model,
 * and translating return values from a model to displayable messages on a view.
 */
public class CountController implements CountObserver {
    private final CountModel model;
    private CountView view;

    public CountController(CountModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setView(CountView view) {
        this.view = view;
    }

    public void incrementPressed() {
        model.updateBy(1);
    }

    public void decrementPressed() {
        model.updateBy(-1);
    }

    @Override
    public void update(int count) {
        String message = "Count is " + model.getCount();
        view.setLabelMessage(message);
    }
}
