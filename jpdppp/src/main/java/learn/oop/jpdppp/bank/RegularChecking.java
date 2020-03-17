package learn.oop.jpdppp.bank;

public class RegularChecking extends CheckingAccount {
    @Override
    public double interestRate() {
        return 0.0;
    }

    @Override
    public String accountType() {
        return "Regular Checking";
    }
}
