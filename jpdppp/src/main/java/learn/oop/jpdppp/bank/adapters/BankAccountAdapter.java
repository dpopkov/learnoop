package learn.oop.jpdppp.bank.adapters;

import learn.oop.jpdppp.bank.BankAccount;

public class BankAccountAdapter implements FIAccountInfo {
    private static final int PENNIES_PER_DOLLAR = 100;

    private final BankAccount account;

    public BankAccountAdapter(BankAccount account) {
        this.account = account;
    }

    @Override
    public int balance() {
        return account.getBalance() / PENNIES_PER_DOLLAR;
    }

    @Override
    public boolean isForeign() {
        return account.isForeign();
    }

    @Override
    public String accountType() {
        return "deposit";
    }
}
