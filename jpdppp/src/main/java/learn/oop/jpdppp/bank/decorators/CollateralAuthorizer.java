package learn.oop.jpdppp.bank.decorators;

import learn.oop.jpdppp.bank.BankAccount;

/**
 * It authorizes the loan if the balance of the specified bank account
 * is sufficiently high, and denies the loan otherwise.
 */
public class CollateralAuthorizer implements LoanAuthorizer {
    private final BankAccount account;

    public CollateralAuthorizer(BankAccount account) {
        this.account = account;
    }

    @Override
    public boolean authorizeLoan(int amount) {
        return account.hasEnoughCollateral(amount);
    }
}
