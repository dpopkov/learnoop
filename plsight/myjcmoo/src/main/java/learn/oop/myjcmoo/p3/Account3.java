package learn.oop.myjcmoo.p3;

import java.math.BigDecimal;

/*
In this version of Account all the explicit logic that deals with freezing is removed.
The entire logic was wrapped in separate classes.
 */
public class Account3 {
    private boolean isVerified;
    private boolean isClosed;
    private BigDecimal balance;
    private Freezable freezable;

    public Account3(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        freezable = new FreezableActive(onUnfrozen);
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
        freezable = freezable.freezeAccount();
    }

    public void deposit(BigDecimal amount) {
        if (isClosed) {
            return;
        }
        freezable = freezable.deposit();
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (isClosed) {
            return;
        }
        if (!isVerified) {
            return;
        }
        freezable = freezable.withdraw();
        balance = balance.subtract(amount);
    }
}
