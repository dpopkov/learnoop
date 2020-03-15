package learn.oop.jpdppp.bank;

public class RegularChecking extends CheckingAccount {
    public RegularChecking(int acctNum) {
        super(acctNum);
    }

    @Override
    public void addInterest() {
        // do nothing
    }

    @Override
    public String toString() {
        return "Regular checking account " + acctNum + ": balance=" + balance + ", is " + (isForeign() ? "foreign" : "domestic");
    }
}
