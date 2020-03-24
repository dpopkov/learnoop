package learn.oop.jpdppp.examples.mvcjavafx;

/**
 * This controller is responsible for translating events on a view into actions on a model,
 * and translating return values from a model to displayable messages on a view.
 */
public class CountController {
    private final CountModel model;

    public CountController(CountModel model) {
        this.model = model;
    }

    public String incrementPressed() {
        model.updateBy(1);
        return response();
    }

    public String decrementPressed() {
        model.updateBy(-1);
        return response();
    }

    private String response() {
        return "Count is " + model.getCount();
    }
}
