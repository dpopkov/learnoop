package learn.oop.jpdppp.bank.decorators;

import learn.oop.jpdppp.bank.BankAccount;

/**
 * wrapper class that does nothing. It has to be extended to create Decorators.
 * It depends on subclasses to override its methods with interesting behavior.
 */
public abstract class BankAccountWrapper implements BankAccount {
    protected final BankAccount account;

    protected BankAccountWrapper(BankAccount account) {
        this.account = account;
    }

    @Override
    public int getAcctNum() {
        return account.getAcctNum();
    }

    @Override
    public int getBalance() {
        return account.getBalance();
    }

    @Override
    public boolean isForeign() {
        return account.isForeign();
    }

    @Override
    public void setForeign(boolean foreign) {
        account.setForeign(foreign);
    }

    @Override
    public void deposit(int amt) {
        account.deposit(amt);
    }

    @Override
    public boolean hasEnoughCollateral(int loan) {
        return account.hasEnoughCollateral(loan);
    }

    @Override
    public void addInterest() {
        account.addInterest();
    }

    @Override
    public int fee() {
        return account.fee();
    }

    @Override
    public int compareTo(BankAccount o) {
        return account.compareTo(o);
    }

    @Override
    public int hashCode() {
        return account.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return account.equals(obj);
    }

    @Override
    public String toString() {
        return account.toString();
    }
}
