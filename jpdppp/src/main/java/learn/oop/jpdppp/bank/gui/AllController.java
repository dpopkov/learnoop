package learn.oop.jpdppp.bank.gui;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.BankAccount;
import learn.oop.jpdppp.bank.BankEvent;
import learn.oop.jpdppp.bank.BankObserver;

public class AllController implements BankObserver {
    private final Bank bank;
    private AllView view;

    public AllController(Bank bank) {
        this.bank = bank;
        bank.addObserver(BankEvent.NEW, this);
        bank.addObserver(BankEvent.DEPOSIT, this);
        bank.addObserver(BankEvent.SET_FOREIGN, this);
        bank.addObserver(BankEvent.INTEREST, this);
    }

    public void setView(AllView view) {
        this.view = view;
        refreshAccounts();
    }

    public void interestButton() {
        bank.addInterest();
    }

    @Override
    public void update(BankEvent event, BankAccount account, int depositAmount) {
        refreshAccounts();
    }

    private void refreshAccounts() {
        StringBuilder result = new StringBuilder();
        for (BankAccount a : bank) {
            result.append(a.toString()).append("\n");
        }
        view.setAccounts(result.toString());
    }
}
