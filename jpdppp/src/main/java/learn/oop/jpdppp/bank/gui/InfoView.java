package learn.oop.jpdppp.bank.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InfoView {
    private final Pane root;
    private final TextField balanceField = createTextField(true);
    private final TextField approvedField = createTextField(true);
    private final ChoiceBox<String> foreignBox = new ChoiceBox<>();

    public InfoView(InfoController controller) {
        controller.setView(this);
        root = createNodeHierarchy(controller);
    }

    public Pane getRoot() {
        return root;
    }

    public void setBalance(String balance) {
        balanceField.setText(balance);
    }

    public void setForeign(boolean isForeign) {
        foreignBox.setValue(isForeign ? "Foreign" : "Domestic");
    }

    private Pane createNodeHierarchy(InfoController controller) {
        Button selectButton = new Button("Select Account");
        Button depositButton = new Button("Deposit");
        Button loanButton = new Button("Approve Loan");
        Button ownershipButton = new Button("Set Ownership");

        Label title = new Label("Access an Existing Account");
        double size = title.getFont().getSize();
        title.setFont(new Font(size * 2));
        title.setTextFill(Color.GREEN);

        TextField selectField = createTextField(false);
        Node p2 = createHBox(new Label("Account #"), selectField, selectButton);
        Node p3 = createHBox(new Label("Balance:"), balanceField);
        Node p4 = createBorderedVBox(p2, p3);

        TextField depositField = createTextField(false);
        Node p5 = createHBox(new Label("Amt to Deposit:"), depositField, depositButton);
        Node p6 = createBorderedVBox(p5);

        TextField loanField = createTextField(false);
        Node p7 = createHBox(new Label("Loan amt:"), loanField, loanButton);
        Node p8 = createHBox(new Label("Approval Status:"), approvedField);
        Node p9 = createBorderedVBox(p7, p8);

        foreignBox.getItems().addAll("Foreign", "Domestic");
        Node p10 = createHBox(new Label("Ownership"), foreignBox, ownershipButton);
        Node p11 = createBorderedVBox(p10);

        selectButton.setOnAction(e -> controller.selectButton(selectField.getText()));
        depositButton.setOnAction(e -> controller.depositButton(depositField.getText()));
        loanButton.setOnAction(e -> controller.loanButton(loanField.getText()));
        ownershipButton.setOnAction(e -> controller.foreignButton(foreignBox.getValue()));

        VBox p1 = new VBox();
        p1.setAlignment(Pos.TOP_CENTER);
        p1.setPadding(new Insets(10));
        p1.getChildren().addAll(title, p4, p6, p9, p11);
        return p1;
    }

    private Node createBorderedVBox(Node... children) {
        VBox vb = new VBox(4);
        vb.setPadding(new Insets(8));
        BorderStroke bs = new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, null, null, new Insets(10));
        vb.setBorder(new Border(bs));
        vb.getChildren().addAll(children);
        return vb;
    }

    private Node createHBox(Node... children) {
        HBox hb = new HBox(5);
        hb.setAlignment(Pos.CENTER_LEFT);
        hb.getChildren().addAll(children);
        hb.setPadding(new Insets(2));
        return hb;
    }

    private TextField createTextField(boolean disable) {
        TextField result = new TextField();
        result.setPrefWidth(85);
        result.setDisable(disable);
        return result;
    }

    public void setLoanResponse(String response) {
        approvedField.setText(response);
    }
}
