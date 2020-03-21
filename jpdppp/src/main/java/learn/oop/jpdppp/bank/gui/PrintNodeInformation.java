package learn.oop.jpdppp.bank.gui;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrintNodeInformation extends Application {
    private Label label;
    private ChoiceBox<String> choiceBox;
    private Button button;
    private Pane p1;
    private Pane p2;

    @Override
    public void start(Stage stage) {
        createNodeHierarchy();
        stage.setScene(new Scene(p1));
        stage.setTitle("Bank Account Demo");
        stage.show();

        System.out.println("NODE\tWID TH");
        printNodeSize(label);
        printNodeSize(choiceBox);
        printNodeSize(p2);
        printNodeSize(button);
        printNodeSize(p1);
    }

    private void createNodeHierarchy() {
        p2 = new VBox(10);
        p2.setId("p2");
        label = new Label("Select Account Type:");
        label.setId("label");
        choiceBox = new ChoiceBox<>();
        choiceBox.setId("choiceBox");
        choiceBox.getItems().addAll("Savings", "Checking", "Interest Checking");
        p2.getChildren().addAll(label, choiceBox);

        p1 = new HBox(10);
        p1.setId("p1");
        button = new Button("Create Account");
        button.setId("button");
        p1.setPadding(new Insets(10));
        p1.getChildren().addAll(p2, button);
    }

    private void printNodeSize(Node n) {
        Bounds b = n.getLayoutBounds();
        int w = (int) b.getWidth();
        int h = (int) b.getHeight();
        System.out.println(n.getId() + "\t" + w + " " + h);
    }
}
