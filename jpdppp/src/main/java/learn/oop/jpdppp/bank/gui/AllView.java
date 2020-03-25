package learn.oop.jpdppp.bank.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AllView {
    private final Pane root;
    private final TextArea accounts = new TextArea();

    public AllView(AllController controller) {
        controller.setView(this);
        root = createNodeHierarchy(controller);
    }

    private Pane createNodeHierarchy(AllController controller) {
        accounts.setPrefColumnCount(32);
        accounts.setPrefRowCount(12);

        Button interestButton = new Button("Add Interest");
        interestButton.setOnAction(e -> controller.interestButton());

        VBox p1 = new VBox(8);
        p1.setAlignment(Pos.TOP_CENTER);
        p1.setPadding(new Insets(10));
        Label title = new Label("Manage All Accounts");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        title.setTextFill(Color.GREEN);
        p1.getChildren().addAll(title, accounts, interestButton);
        return p1;
    }

    public Pane getRoot() {
        return root;
    }

    public void setAccounts(String allAccountsText) {
        accounts.setText(allAccountsText);
    }
}
