package learn.oop.jpdppp.bank;

public abstract class CheckingAccount implements TypeStrategy {

    @Override
    public double collateralRatio() {
        return 2.0 / 3.0;
    }

    @Override
    public abstract double interestRate();

    @Override
    public abstract String accountType();
}
