package learn.oop.jpdppp.bank.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CreationView {
    public static final String INITIAL_TITLE = "Create a New Bank Account";

    private final Pane root;
    private final Label title = new Label(INITIAL_TITLE);

    public CreationView(CreationController controller) {
        controller.setView(this);
        root = createNodeHierarchy(controller);
    }

    public Pane getRoot() {
        return root;
    }

    public void setTitle(String msg) {
        title.setText(msg);
    }

    private Pane createNodeHierarchy(CreationController controller/*, Stage stage*/) {
        Label type = new Label("Select Account Type:");
        ChoiceBox<String> typesBox = new ChoiceBox<>();
        typesBox.getItems().addAll(controller.getAccountTypes());

        VBox p3 = new VBox(8);
        p3.setAlignment(Pos.CENTER);
        p3.setPadding(new Insets(10));
        p3.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));
        p3.getChildren().addAll(type, typesBox);

        VBox p4 = new VBox(8);
        p4.setAlignment(Pos.CENTER);
        p4.setPadding(new Insets(10));

        CheckBox foreignBox = new CheckBox("foreign owned?");
        foreignBox.selectedProperty().addListener(
                (obs, oldValue, newValue) -> foreignBox.setTextFill(newValue ? Color.GREEN : Color.RED));
        Button button = new Button("Create Account");
        button.setDisable(true);
        button.disableProperty().bind(typesBox.valueProperty().isNull());
        p4.getChildren().addAll(foreignBox, button);

        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        p2.setPadding(new Insets(10));
        p2.getChildren().addAll(p3, p4);

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);
        p1.setPadding(new Insets(10));

        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        title.setTextFill(Color.GREEN);
        p1.getChildren().addAll(title, p2);

        p1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            foreignBox.setSelected(false);
            typesBox.setValue(null);
            title.setText(INITIAL_TITLE);
        });

        button.setOnAction(event -> controller.buttonPressed(
                typesBox.getSelectionModel().getSelectedIndex(), foreignBox.isSelected()));
        return p1;
    }
}
