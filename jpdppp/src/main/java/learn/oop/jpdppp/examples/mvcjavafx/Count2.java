package learn.oop.jpdppp.examples.mvcjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Count2 extends Application {
    @Override
    public void start(Stage stage) {
        CountModel model = new CountModel();
        CountController controller = new CountController(model);
        CountView view = new CountView(controller);
        stage.setScene(new Scene(view.getRoot()));
        stage.show();
    }
}
