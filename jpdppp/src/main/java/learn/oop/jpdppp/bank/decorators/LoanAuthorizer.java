package learn.oop.jpdppp.bank.decorators;

import learn.oop.jpdppp.bank.BankAccount;

public interface LoanAuthorizer {
    boolean authorizeLoan(int amount);

    static LoanAuthorizer getAuthorizer(BankAccount account) {
        LoanAuthorizer auth = new CollateralAuthorizer(account);
        auth = new CreditScoreAuthorizer(auth);
        return new GoodCustomerAuthorizer(auth);
    }
}
