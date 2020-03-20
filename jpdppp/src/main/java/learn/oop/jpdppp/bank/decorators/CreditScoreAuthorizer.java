package learn.oop.jpdppp.bank.decorators;

import java.util.Random;

public class CreditScoreAuthorizer extends AuthorizerWrapper {
    private final int score;

    public CreditScoreAuthorizer(LoanAuthorizer authorizer) {
        super(authorizer);
        // Mock up the credit score
        Random random = new Random();
        score = 300 + random.nextInt(500);
    }

    @Override
    public boolean authorizeLoan(int amount) {
        if (score > 700 && amount < 100000) {
            return true;
        } else if (score < 500) {
            return false;
        } else {
            return authorizer.authorizeLoan(amount);
        }
    }
}
