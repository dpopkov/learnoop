package learn.oop.myjcmoo.p3;

import learn.oop.myjcmoo.p3.accountstates.Active;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Account4 {
    private BigDecimal balance;
    private AccountState accountState;

    public Account4(AccountUnfrozen onUnfrozen) {
        balance = BigDecimal.ZERO;
        accountState = new Active(onUnfrozen);
    }

    public void holderVerified() {
        accountState = accountState.holderVerified();
    }

    public void closeAccount() {
        accountState = accountState.closeAccount();
    }

    public void freezeAccount() {
        accountState = accountState.freezeAccount();
    }

    public void deposit(BigDecimal amount) {
        accountState = accountState.deposit(amount, this::addToBalance);
    }

    private void addToBalance(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        accountState = accountState.withdraw(balance, amount, this::subtractFromBalance);
    }

    private void subtractFromBalance(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
}
