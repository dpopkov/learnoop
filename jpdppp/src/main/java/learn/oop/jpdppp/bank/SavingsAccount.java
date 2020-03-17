package learn.oop.jpdppp.bank;

public class SavingsAccount implements TypeStrategy {
    private static final double RATE = 0.01;

    @Override
    public double collateralRatio() {
        return 0.5;
    }

    @Override
    public double interestRate() {
        return RATE;
    }

    @Override
    public String accountType() {
        return "Savings";
    }
}
