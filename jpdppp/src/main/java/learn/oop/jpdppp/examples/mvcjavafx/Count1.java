package learn.oop.jpdppp.examples.mvcjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Count1 extends Application {
    private int count = 0;
    private final Label label = new Label("Count is 0");

    @Override
    public void start(Stage stage) {
        Button incButton = new Button("Increment");
        Button decButton = new Button("Decrement");
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(label, incButton, decButton);
        incButton.setOnAction(e -> updateBy(1));
        decButton.setOnAction(e -> updateBy(-1));
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    private void updateBy(int value) {
        count += value;
        label.setText("Count is " + count);
    }
}
