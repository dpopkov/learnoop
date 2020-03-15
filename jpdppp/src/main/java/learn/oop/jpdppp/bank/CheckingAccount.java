package learn.oop.jpdppp.bank;

public class CheckingAccount extends AbstractBankAccount {

    public CheckingAccount(int acctNum) {
        super(acctNum);
    }

    @Override
    public boolean hasEnoughCollateral(int loan) {
        return balance >= 2.0 * loan / 3.0;
    }

    @Override
    public void addInterest() {
        // do nothing
    }

    @Override
    public String toString() {
        return "CheckingAccount " + acctNum + ": balance=" + balance + ", is " + (isForeign() ? "foreign" : "domestic");
    }
}
