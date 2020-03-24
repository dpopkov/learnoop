package learn.oop.jpdppp.bank;

public class InputController {
    private final String accountTypePrompt = buildAccountTypePrompt();
    private final Bank bank;
    private int current = 0;

    public InputController(Bank bank) {
        this.bank = bank;
    }

    public String getAccountTypePrompt() {
        return accountTypePrompt;
    }

    public String newCmd(int type, boolean isForeign) {
        int acctNum = bank.newAccount(type, isForeign);
        current = acctNum;
        return "Your new account number is " + acctNum;
    }

    public String selectCmd(int acctNum) {
        current = acctNum;
        int balance = bank.getBalance(current);
        return String.format("The balance of account %d is %d%n", current, balance);
    }

    public String depositCmd(int amount) {
        bank.deposit(current, amount);
        return String.format("%d deposited", amount);
    }

    public String loanCmd(int loanAmount) {
        boolean authorized = bank.authorizeLoan(current, loanAmount);
        return authorized ? "Your loan is approved" : "Your loan is denied";
    }

    public String showCmd() {
        return bank.toString();
    }

    public String interestCmd() {
        bank.addInterest();
        return "Interests added";
    }

    public String setForeignCmd(boolean isForeign) {
        bank.setForeign(current, isForeign);
        return String.format("Account %d is set %s%n", current, isForeign ? "foreign" : "domestic");
    }

    private String buildAccountTypePrompt() {
        AccountFactory[] factories = AccountFactories.values();
        StringBuilder builder = new StringBuilder("Enter account type (");
        int last = factories.length - 1;
        for (int i = 0; i < last; i++) {
            builder.append(i + 1).append("=").append(factories[i]).append(", ");
        }
        builder.append(last + 1).append("=").append(factories[last]).append("): ");
        return builder.toString();
    }
}
