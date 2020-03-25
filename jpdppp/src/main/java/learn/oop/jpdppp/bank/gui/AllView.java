package learn.oop.jpdppp.bank.gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import learn.oop.jpdppp.bank.BankAccount;

public class AllView {
    private final Pane root;
    private final TableView<BankAccount> accounts = new TableView<>();

    public AllView(AllController controller) {
        root = createNodeHierarchy(controller);
        initTableView(controller);
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

    private void initTableView(AllController controller) {
        TableColumn<BankAccount, Integer> acctNumCol = new TableColumn<>("Account Number");
        acctNumCol.setCellValueFactory(p -> {
            BankAccount ba = p.getValue();
            int acctNum = ba.getAcctNum();
            return new SimpleObjectProperty<>(acctNum);
        });
        TableColumn<BankAccount, String> typeCol = new TableColumn<>("Account Type");
        typeCol.setCellValueFactory(p -> {
            BankAccount account = p.getValue();
            // todo: remove this substring operation after adding method typeName() to BankAccount
            String s = account.toString().substring(0, account.toString().indexOf(" account "));
            return new SimpleObjectProperty<>(s);
        });
        TableColumn<BankAccount, Integer> balanceCol = new TableColumn<>("Balance");
        balanceCol.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getBalance()));
        TableColumn<BankAccount, String> foreignCol = new TableColumn<>("Owner Status");
        foreignCol.setCellValueFactory(p -> {
            boolean isForeign = p.getValue().isForeign();
            String owner = isForeign ? "Foreign" : "Domestic";
            return new SimpleObjectProperty<>(owner);
        });
        //noinspection unchecked
        accounts.getColumns().addAll(acctNumCol, typeCol, balanceCol, foreignCol);
        accounts.setItems(controller.getAccountList());
        accounts.setPrefSize(380, 240);
    }

    public Pane getRoot() {
        return root;
    }
}
