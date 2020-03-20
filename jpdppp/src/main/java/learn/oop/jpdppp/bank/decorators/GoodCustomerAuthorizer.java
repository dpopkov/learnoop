package learn.oop.jpdppp.bank.decorators;

import java.util.Random;

public class GoodCustomerAuthorizer extends AuthorizerWrapper {
    private final boolean isGood;

    public GoodCustomerAuthorizer(LoanAuthorizer authorizer) {
        super(authorizer);
        // Mock up the customer status
        Random random = new Random();
        isGood = random.nextBoolean();
    }

    @Override
    public boolean authorizeLoan(int amount) {
        if (isGood && amount < 200000) {
            return true;
        } else {
            return authorizer.authorizeLoan(amount);
        }
    }
}
