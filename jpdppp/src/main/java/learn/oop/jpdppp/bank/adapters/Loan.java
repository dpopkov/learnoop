package learn.oop.jpdppp.bank.adapters;

public class Loan {
    private final double monthlyRate;
    private final double monthlyPayment;
    private final boolean isDomestic;
    private double balance;
    private int paymentsLeft;

    public Loan(double amount, double yearlyRate, int numYears, boolean isDomestic) {
        balance = amount;
        paymentsLeft = numYears * 12;
        this.isDomestic = isDomestic;
        monthlyRate = yearlyRate / 12.0;
        monthlyPayment = (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -paymentsLeft));
    }

    public double remainingPrincipal() {
        return balance;
    }

    public int paymentsLeft() {
        return paymentsLeft;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public double monthlyPayment() {
        return monthlyPayment;
    }

    public void makePayment() {
        balance = balance + (balance * monthlyRate) - monthlyPayment;
        paymentsLeft--;
    }
}
