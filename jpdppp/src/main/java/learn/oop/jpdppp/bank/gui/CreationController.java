package learn.oop.jpdppp.bank.gui;

import learn.oop.jpdppp.bank.*;

public class CreationController implements BankObserver {
    private final Bank bank;
    private CreationView view;

    public CreationController(Bank bank) {
        this.bank = bank;
        bank.addObserver(BankEvent.NEW, this);
    }

    public void setView(CreationView view) {
        this.view = view;
    }

    /**
     * Creates a new account.
     * @param type type of account (starting from 0)
     * @param isForeign foreign or domestic flag
     */
    public void buttonPressed(int type, boolean isForeign) {
        bank.newAccount(type + 1, isForeign);
    }

    @Override
    public void update(BankEvent event, BankAccount account, int depositAmount) {
        view.setTitle("Account " + account.getAcctNum() + " created");
    }

    public String[] getAccountTypes() {
        AccountFactory[] factories = AccountFactories.values();
        String[] types = new String[factories.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = factories[i].toString();
        }
        return types;
    }
}
