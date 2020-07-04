package learn.oop.myjcmoo.p3.accountstates;

import learn.oop.myjcmoo.p3.AccountState;

import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * The closed state always remains closed.
 */
public class Closed implements AccountState {
    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        return this;
    }

    @Override
    public AccountState withdraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
        return this;
    }

    @Override
    public AccountState freezeAccount() {
        return this;
    }

    @Override
    public AccountState holderVerified() {
        return this;
    }

    @Override
    public AccountState closeAccount() {
        return this;
    }
}
