package learn.oop.jpdppp.bank;

public interface AccountFactory {
    static BankAccount createSavings(int acctNum) {
        return new SavingsAccount(acctNum);
    }

    static BankAccount createRegularChecking(int acctNum) {
        return new RegularChecking(acctNum);
    }

    static BankAccount createInterestChecking(int acctNum) {
        return new InterestChecking(acctNum);
    }

    static BankAccount createAccount(int type, int acctNum) {
        BankAccount bankAccount;
        if (type == 1) {
            bankAccount = createSavings(acctNum);
        } else if (type == 2) {
            bankAccount = createRegularChecking(acctNum);
        } else {
            bankAccount = createInterestChecking(acctNum);
        }
        return bankAccount;
    }
}
