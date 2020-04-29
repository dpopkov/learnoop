package learn.oop.myjcmoo.p3.accountstates;

import learn.oop.myjcmoo.p3.AccountState;
import learn.oop.myjcmoo.p3.AccountUnfrozen;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Frozen implements AccountState {
    private final AccountUnfrozen onUnfrozen;

    public Frozen(AccountUnfrozen onUnfrozen) {
        this.onUnfrozen = onUnfrozen;
    }

    @Override
    public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
        addToBalance.accept(amount);
        return unfreeze();
    }

    @Override
    public AccountState withdraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
        if (balance.compareTo(amount) >= 0) {
            subtractFromBalance.accept(amount);
        }
        return unfreeze();
    }

    private AccountState unfreeze() {
        onUnfrozen.handle();
        return new Active(onUnfrozen);
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
        return new Closed();
    }
}
