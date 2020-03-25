package learn.oop.jpdppp.bank.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import learn.oop.jpdppp.bank.BankAccount;

public class AllView {
    private final Pane root;
    private final ListView<BankAccount> accounts = new ListView<>();

    public AllView(AllController controller) {
        root = createNodeHierarchy(controller);
        accounts.setItems(controller.getAccountList());
    }

    private Pane createNodeHierarchy(AllController controller) {
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
}
