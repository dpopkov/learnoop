package learn.oop.myjcmoo.p3;

import java.math.BigDecimal;

/* In this class branching if-else was turned into a function. */
public class Account2 {
    private boolean isVerified;
    private boolean isClosed;
    private BigDecimal balance;

    private final AccountUnfrozen onUnfrozen;
    private EnsureUnfrozen ensureUnfrozen;

    public Account2(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        this.onUnfrozen = onUnfrozen;
        ensureUnfrozen = this::stayUnfrozen;
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
        /*
        Advice:
        Try to branch by selecting an object, not a block of code.
        That will let you to move code to other classes.
         */
        ensureUnfrozen = this::unfreeze;
    }

    public void deposit(BigDecimal amount) {
        if (isClosed) {
            return;
        }
        ensureUnfrozen.execute();
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (isClosed) {
            return;
        }
        if (!isVerified) {
            return;
        }
        ensureUnfrozen.execute();
        balance = balance.subtract(amount);
    }

    private void unfreeze() {
        onUnfrozen.handle();
        ensureUnfrozen = this::stayUnfrozen;
    }

    private void stayUnfrozen() {

    }
}
