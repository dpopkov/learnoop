package learn.oop.jpdppp.bank.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.BankAccount;
import learn.oop.jpdppp.bank.BankEvent;
import learn.oop.jpdppp.bank.BankObserver;

public class AllController implements BankObserver {
    private final Bank bank;
    private final ObservableList<BankAccount> accounts = FXCollections.observableArrayList();

    public AllController(Bank bank) {
        this.bank = bank;
        bank.addObserver(BankEvent.NEW, this);
        bank.addObserver(BankEvent.DEPOSIT, this);
        bank.addObserver(BankEvent.SET_FOREIGN, this);
        bank.addObserver(BankEvent.INTEREST, this);
        for (BankAccount a : bank) {
            accounts.add(a);
        }
    }

    public void interestButton() {
        bank.addInterest();
    }

    @Override
    public void update(BankEvent event, BankAccount account, int depositAmount) {
        if (event == BankEvent.INTEREST) {
            refreshAllAccounts();
        } else if (event == BankEvent.NEW) {
            accounts.add(account);
        } else {
            int i = accounts.indexOf(account);
            refreshAccount(i);
        }
    }

    public ObservableList<BankAccount> getAccountList() {
        return accounts;
    }

    private void refreshAccount(int i) {
        // a no-op, to force the list to notify its observer
        accounts.set(i, accounts.get(i));
    }

    private void refreshAllAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            refreshAccount(i);
        }
    }
}
