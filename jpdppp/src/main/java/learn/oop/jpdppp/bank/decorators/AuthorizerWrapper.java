package learn.oop.jpdppp.bank.decorators;

/**
 * Standard default wrapper for the decorator pattern
 * that does nothing and has to be extended.
 */
public abstract class AuthorizerWrapper implements LoanAuthorizer {
    protected final LoanAuthorizer authorizer;

    protected AuthorizerWrapper(LoanAuthorizer authorizer) {
        this.authorizer = authorizer;
    }

    @Override
    public boolean authorizeLoan(int amount) {
        return authorizer.authorizeLoan(amount);
    }
}
