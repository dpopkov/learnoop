package learn.oop.jpdppp.bank.decorators;

import learn.oop.jpdppp.bank.BankAccount;

import java.util.Date;

public class SuspiciousAccount extends BankAccountWrapper {

    public SuspiciousAccount(BankAccount account) {
        super(account);
    }

    @Override
    public void deposit(int amount) {
        Date date = new Date();
        String msg = "On " + date + " account #" + account.getAcctNum() + " deposited " + amount;
        System.out.println(msg);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "## " + account.toString();
    }
}
