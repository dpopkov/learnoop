package learn.oop.jpdppp.bank.iterators;

import learn.oop.jpdppp.bank.BankAccount;

public class MaxBalanceVisitor implements Visitor<BankAccount, Integer> {
    private int maxBalance = 0;

    @Override
    public Integer result() {
        return maxBalance;
    }

    @Override
    public void accept(BankAccount account) {
        int balance = account.getBalance();
        if (balance > maxBalance) {
            maxBalance = balance;
        }
    }
}
