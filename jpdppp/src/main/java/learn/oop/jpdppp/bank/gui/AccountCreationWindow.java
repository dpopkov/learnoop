package learn.oop.jpdppp.bank.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AccountCreationWindow extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = createNodeHierarchy();
        stage.setScene(new Scene(root));
        stage.setTitle("Bank Account Demo");
        stage.show();
    }

    private Pane createNodeHierarchy() {
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
        Button button = new Button("Create Account");
        p4.getChildren().addAll(checkBox, button);

        HBox p2 = new HBox(8);
        p2.setAlignment(Pos.CENTER);
        p2.setPadding(new Insets(10));
        p2.getChildren().addAll(p3, p4);

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.CENTER);
        p1.setPadding(new Insets(10));

        Label title = new Label("Create a New Bank Account");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        title.setTextFill(Color.GREEN);
        p1.getChildren().addAll(title, p2);

        button.setOnAction(event -> {
            String foreign = checkBox.isSelected() ? "Foreign " : "";
            String accountType = choiceBox.getValue();
            title.setText(foreign + accountType + " Account Created");
        });
        return p1;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
