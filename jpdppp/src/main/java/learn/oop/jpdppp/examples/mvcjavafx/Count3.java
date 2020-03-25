package learn.oop.jpdppp.examples.mvcjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Count3 extends Application {
    @Override
    public void start(Stage stage) {
        CountModel model = new CountModel();
        CountController counter = new CountController(model);
        CountView countView = new CountView(counter);
        WatcherController watcher = new WatcherController(model);
        WatcherView watcherView = new WatcherView(watcher);

        Pane leftPane = countView.getRoot();
        Pane rightPane = watcherView.getRoot();
        HBox pane = new HBox();
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                null, null, new Insets(10))
        );
        leftPane.setBorder(border);
        rightPane.setBorder(border);
        pane.getChildren().addAll(leftPane, rightPane);

        stage.setScene(new Scene(pane));
        stage.show();
    }
}
