package learn.oop.myjcmoo.p3;

public class FreezableFrozen implements Freezable {
    private final AccountUnfrozen onUnfrozen;

    public FreezableFrozen(AccountUnfrozen onUnfrozen) {
        this.onUnfrozen = onUnfrozen;
    }

    @Override
    public Freezable deposit() {
        return unfreeze();
    }

    @Override
    public Freezable withdraw() {
        return unfreeze();
    }

    private Freezable unfreeze() {
        onUnfrozen.handle();
        return new FreezableActive(onUnfrozen);
    }

    @Override
    public Freezable freezeAccount() {
        return this;
    }
}
