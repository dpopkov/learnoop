package learn.oop.jpdppp.examples.mvcjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CountView {
    private final Pane root;

    public CountView(CountController controller) {
        root = createNodeHierarchy(controller);
    }

    public Parent getRoot() {
        return root;
    }

    private Pane createNodeHierarchy(CountController controller) {
        Label label = new Label("Count is 0");
        Button incButton = new Button("Increment");
        Button decButton = new Button("Decrement");
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(label, incButton, decButton);
        incButton.setOnAction(e -> {
            String response = controller.incrementPressed();
            label.setText(response);
        });
        decButton.setOnAction(e -> {
            String response = controller.decrementPressed();
            label.setText(response);
        });
        return vBox;
    }
}
