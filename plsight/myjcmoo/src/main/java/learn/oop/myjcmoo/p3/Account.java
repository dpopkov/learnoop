package learn.oop.myjcmoo.p3;

import java.math.BigDecimal;

/**
 * Money account allowing deposits and withdrawals.<br>
 * <h3>Requirements</h3>
 * Client can always deposit money.
 * Client can withdraw only after the account holder has been verified
 * (e.g by showing an ID card once).
 * Client can close the account.
 */
public class Account {
    private boolean isVerified;
    private boolean isClosed;
    private boolean isFrozen;
    private BigDecimal balance;

    private AccountUnfrozen onUnfrozen;

    public Account(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        this.onUnfrozen = onUnfrozen;
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
        isFrozen = true;
    }

    public void deposit(BigDecimal amount) {
        if (isClosed) {
            return;
        }
        if (isFrozen) {
            isFrozen = false;
            onUnfrozen.handle();
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (isClosed) {
            return;
        }
        if (!isVerified) {
            return;
        }
        if (isFrozen) {
            isFrozen = false;
            onUnfrozen.handle();
        }
        balance = balance.subtract(amount);
    }
}
