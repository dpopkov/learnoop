package learn.oop.jpdppp.examples.composites.gui;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NodeTraversal extends Application {
    private VBox p1;

    @Override
    public void start(Stage stage) {
        createNodeHierarchy();
        stage.setScene(new Scene(p1));
        stage.setTitle("Bank Account Demo");
        stage.show();
        printAllNodes(p1);
        Node n = getWidestControl(p1);
        System.out.println("The widest control is " + n.getId());
    }

    private void printAllNodes(Node n) {
        printNodeSize(n);
        if (n instanceof Pane) {
            Pane p = (Pane) n;
            for (Node child : p.getChildren()) {
                printAllNodes(child);
            }
        }
    }

    private void printNodeSize(Node n) {
        Bounds b = n.getLayoutBounds();
        int w = (int) b.getWidth();
        int h = (int) b.getHeight();
        System.out.printf("%-10s \t%4d %3d%n", n.getId(), w, h);
    }

    private Node getWidestControl(Node n) {
        if (n instanceof Control) {
            return n;
        }
        Node widest = null;
        double maxWidth = -1;
        Pane p = (Pane) n;
        for (Node child : p.getChildren()) {
            Node max = getWidestControl(child);
            double w = max.getLayoutBounds().getWidth();
            if (w > maxWidth) {
                widest = max;
                maxWidth = w;
            }
        }
        return widest;
    }

    private void createNodeHierarchy() {
        VBox p3 = new VBox(8);
        p3.setId("p3");
        p3.setAlignment(Pos.CENTER);
        p3.setPadding(new Insets(10));
        p3.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));

        Label type = new Label("Select Account Type:");
        type.setId("type");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setId("choiceBox");
        choiceBox.getItems().addAll("Savings", "Checking", "Interest Checking");
        p3.getChildren().addAll(type, choiceBox);

        VBox p4 = new VBox(8);
        p4.setId("p4");
        p4.setAlignment(Pos.CENTER);
        p4.setPadding(new Insets(10));

        CheckBox checkBox = new CheckBox("foreign owned?");
        checkBox.setId("checkBox");
        Button button = new Button("Create Account");
        button.setId("button");
        p4.getChildren().addAll(checkBox, button);

        HBox p2 = new HBox(8);
        p2.setId("p2");
        p2.setAlignment(Pos.CENTER);
        p2.setPadding(new Insets(10));
        p2.getChildren().addAll(p3, p4);

        p1 = new VBox(8);
        p1.setId("p1");
        p1.setAlignment(Pos.CENTER);
        p1.setPadding(new Insets(10));

        Label title = new Label("Create a New Bank Account");
        title.setId("title");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        title.setTextFill(Color.GREEN);
        p1.getChildren().addAll(title, p2);

        button.setOnAction(event -> {
            String foreign = checkBox.isSelected() ? "Foreign " : "";
            String accountType = choiceBox.getValue();
            title.setText(foreign + accountType + " Account Created");
        });
    }
}
