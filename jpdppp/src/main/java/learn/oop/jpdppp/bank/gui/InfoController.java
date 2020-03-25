package learn.oop.jpdppp.bank.gui;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.BankAccount;
import learn.oop.jpdppp.bank.BankEvent;
import learn.oop.jpdppp.bank.BankObserver;

public class InfoController implements BankObserver {
    private final Bank bank;
    private int current = 0;
    private InfoView view;

    public InfoController(Bank bank) {
        this.bank = bank;
        bank.addObserver(BankEvent.DEPOSIT, this);
        bank.addObserver(BankEvent.INTEREST, this);
        bank.addObserver(BankEvent.SET_FOREIGN, this);
    }

    public void setView(InfoView view) {
        this.view = view;
    }

    public void selectButton(String s) {
        current = Integer.parseInt(s);
        view.setBalance(Integer.toString(bank.getBalance(current)));
        view.setForeign(bank.isForeign(current));
        view.setLoanResponse("");
    }

    public void depositButton(String s) {
        int amount = Integer.parseInt(s);
        bank.deposit(current, amount);
    }

    public void loanButton(String s) {
        int loan = Integer.parseInt(s);
        boolean result = bank.authorizeLoan(current, loan);
        view.setLoanResponse(result ? "APPROVED" : "DENIED");
    }

    public void foreignButton(String s) {
        bank.setForeign(current, "Foreign".equals(s));
    }

    @Override
    public void update(BankEvent event, BankAccount account, int depositAmount) {
        if (event == BankEvent.SET_FOREIGN && account.getAcctNum() == current) {
            view.setForeign(account.isForeign());
        } else if (event == BankEvent.INTEREST) {
            view.setBalance(Integer.toString(bank.getBalance(current)));
        } else if (event == BankEvent.DEPOSIT && account.getAcctNum() == current) {
            view.setBalance(Integer.toString(bank.getBalance(current)));
        }
    }
}
