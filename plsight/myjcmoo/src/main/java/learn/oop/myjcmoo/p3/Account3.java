package learn.oop.myjcmoo.p3;

import learn.oop.myjcmoo.p3.accountstates.Active;

import java.math.BigDecimal;

/*
In this version of Account all the explicit logic that deals with freezing is removed.
The entire logic was wrapped in separate classes.
 */
public class Account3 {
    /*
    Now the account is managing:
    balance, closing, verification, freezing.
     */
    private boolean isVerified;
    private boolean isClosed;
    private BigDecimal balance;
    private AccountState accountState;

    public Account3(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        accountState = new Active(onUnfrozen);
    }

    public void holderVerified() {
        isVerified = true;
    }

    public void closeAccount() {
        isClosed = true;
    }

    public void freezeAccount() {
        if (isClosed) {
            return;
        }
        if (!isVerified) {
            return;
        }
        accountState = accountState.freezeAccount();
    }

    public void deposit(BigDecimal amount) {
        if (isClosed) {
            return;
        }
//        accountState = accountState.deposit();    // After introducing Account4 this class is not working any more
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (isClosed) {
            return;
        }
        if (!isVerified) {
            return;
        }
//        accountState = accountState.withdraw();   // After introducing Account4 this class is not working any more
        balance = balance.subtract(amount);
    }
}
