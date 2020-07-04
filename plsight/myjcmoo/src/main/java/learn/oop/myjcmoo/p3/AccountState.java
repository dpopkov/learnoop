package learn.oop.myjcmoo.p3;

import java.math.BigDecimal;
import java.util.function.Consumer;

/** Contains methods that affect the freezing state. */
public interface AccountState {
    AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);
    AccountState withdraw(BigDecimal balance, BigDecimal amount, Consumer<BigDecimal> subtractFromBalance);
    AccountState freezeAccount();
    AccountState holderVerified();
    AccountState closeAccount();
}
