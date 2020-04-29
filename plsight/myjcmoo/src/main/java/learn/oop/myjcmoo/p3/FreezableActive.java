package learn.oop.myjcmoo.p3;

public class FreezableActive implements Freezable {
    private final AccountUnfrozen onUnfrozen;

    public FreezableActive(AccountUnfrozen onUnfrozen) {
        this.onUnfrozen = onUnfrozen;
    }

    @Override
    public Freezable deposit() {
        return this;
    }

    @Override
    public Freezable withdraw() {
        return this;
    }

    @Override
    public Freezable freezeAccount() {
        return new FreezableFrozen(onUnfrozen);
    }
}
