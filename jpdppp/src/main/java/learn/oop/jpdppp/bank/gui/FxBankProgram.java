package learn.oop.jpdppp.bank.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import learn.oop.jpdppp.bank.*;

import java.util.Map;

public class FxBankProgram extends Application {
    private final SavedBankInfo info = new SavedBankInfo("data/bank20.info.ser");
    private final Map<Integer, BankAccount> accounts = info.getAccounts();
    private final Bank bank = new Bank(accounts, info.nextAcctNum());
    private Pane root1;
    private Pane root2;
    private Pane root3;

    @Override
    public void init() {
        @SuppressWarnings("unused") Auditor auditor = new Auditor(bank);
        bank.addObserver(BankEvent.DEPOSIT, (event, ba, amt) -> {
            if (amt > 1000000) {
                bank.makeSuspicious(ba.getAcctNum());
            }
        });
        CreationController c1 = new CreationController(bank);
        AllController c2 = new AllController(bank);
        InfoController c3 = new InfoController(bank);
        CreationView v1 = new CreationView(c1);
        AllView v2 = new AllView(c2);
        InfoView v3 = new InfoView(c3);

        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                null, null, new Insets(10)));
        root1 = v1.getRoot();
        root2 = v2.getRoot();
        root3 = v3.getRoot();
        root1.setBorder(border);
        root2.setBorder(border);
        root3.setBorder(border);
    }

    @Override
    public void start(Stage stage) {
        VBox left = new VBox();
        left.getChildren().addAll(root1, root2);
        HBox all = new HBox(left, root3);
        stage.setScene(new Scene(all));
        stage.setTitle("Bank demo");
        stage.show();
    }

    @Override
    public void stop() {
        info.saveMap(accounts, bank.nextAcctNum());
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
