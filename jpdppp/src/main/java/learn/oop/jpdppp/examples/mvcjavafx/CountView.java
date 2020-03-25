package learn.oop.jpdppp.examples.mvcjavafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CountView {
    private final Label label = new Label("Count is 0");
    private final Pane root;

    public CountView(CountController controller) {
        root = createNodeHierarchy(controller);
        controller.setView(this);
    }

    public Pane getRoot() {
        return root;
    }

    public void setLabelMessage(String message) {
        label.setText(message);
    }

    private Pane createNodeHierarchy(CountController controller) {
        Button incButton = new Button("Increment");
        Button decButton = new Button("Decrement");
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(label, incButton, decButton);
        incButton.setOnAction(e -> controller.incrementPressed());
        decButton.setOnAction(e -> controller.decrementPressed());
        return vBox;
    }
}
