package learn.oop.jpdppp.bank.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AccountCreationWindow extends Application {

    public static final String INITIAL_TITLE = "Create a New Bank Account";

    @Override
    public void start(Stage stage) {
        Pane root = createNodeHierarchy(stage);
        stage.setScene(new Scene(root));
        stage.setTitle("Bank Account Demo");
        stage.show();
    }

    private Pane createNodeHierarchy(Stage stage) {
        VBox p3 = new VBox(8);
        p3.setAlignment(Pos.CENTER);
        p3.setPadding(new Insets(10));
        p3.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));

        Label type = new Label("Select Account Type:");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Savings", "Checking", "Interest Checking");
        p3.getChildren().addAll(type, choiceBox);

        VBox p4 = new VBox(8);
        p4.setAlignment(Pos.CENTER);
        p4.setPadding(new Insets(10));

        CheckBox checkBox = new CheckBox("foreign owned?");
        checkBox.selectedProperty().addListener(
                (obs, oldValue, newValue) -> checkBox.setTextFill(newValue ? Color.GREEN : Color.RED));
        Button button = new Button("Create Account");
        button.setDisable(true);
        button.disableProperty().bind(choiceBox.valueProperty().isNull());
        p4.getChildren().addAll(checkBox, button);

        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        p2.setPadding(new Insets(10));
        p2.getChildren().addAll(p3, p4);

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);
        p1.setPadding(new Insets(10));

        Label title = new Label(INITIAL_TITLE);
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        title.setTextFill(Color.GREEN);
        title.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> title.setTextFill(Color.RED));
        title.addEventHandler(MouseEvent.MOUSE_EXITED, e -> title.setTextFill(Color.GREEN));
        p1.getChildren().addAll(title, p2);

        p1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            checkBox.setSelected(false);
            choiceBox.setValue(null);
            title.setText(INITIAL_TITLE);
            stage.sizeToScene();
        });

        button.setOnAction(event -> {
            String foreign = checkBox.isSelected() ? "Foreign " : "";
            String accountType = choiceBox.getValue();
            title.setText(foreign + accountType + " Account Created");
            stage.sizeToScene();
        });
        return p1;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
