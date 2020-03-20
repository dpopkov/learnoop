package learn.oop.jpdppp.bank.decorators;

import learn.oop.jpdppp.bank.BankAccount;

public class UnmodifiableAccount extends BankAccountWrapper {

    public UnmodifiableAccount(BankAccount account) {
        super(account);
    }

    @Override
    public void setForeign(boolean foreign) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deposit(int amt) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasEnoughCollateral(int loan) {
        return account.hasEnoughCollateral(loan);
    }

    @Override
    public void addInterest() {
        throw new UnsupportedOperationException();
    }
}
