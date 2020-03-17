package learn.oop.jpdppp.bank;

import java.util.Scanner;

public enum InputCommands implements InputCommand {
    QUIT("quit", (sc, bank, current) -> {
        sc.close();
        System.out.println("Bye!");
        return -1;
    }),
    NEW("new", (sc, bank, current) -> {
        int type = requestAccountType(sc);
        boolean foreign = requestForeign(sc);
        int newCurrent = bank.newAccount(type, foreign);
        System.out.println("Your new account number is " + newCurrent);
        return newCurrent;
    }),
    SELECT("select", (sc, bank, current) -> {
        System.out.print("Enter account #: ");
        int newCurrent = sc.nextInt();
        int balance = bank.getBalance(newCurrent);
        System.out.printf("The balance of account %d is %d%n", newCurrent, balance);
        return newCurrent;
    }),
    DEPOSIT("deposit", (sc, bank, current) -> {
        System.out.print("Enter deposit amount: ");
        int amt = sc.nextInt();
        bank.deposit(current, amt);
        return current;
    }),
    LOAN("loan", (sc, bank, current) -> {
        System.out.print("Enter loan amount: ");
        int loan = sc.nextInt();
        boolean authorized = bank.authorizeLoan(current, loan);
        if (authorized) {
            System.out.println("Your loan is approved");
        } else {
            System.out.println("Your loan is denied");
        }
        return current;
    }),
    SHOW("show", (sc, bank, current) -> {
        System.out.println(bank.toString());
        return current;
    }),
    INTEREST("interest", (sc, bank, current) -> {
        bank.addInterest();
        return current;
    }),
    SET_FOREIGN("set foreign", (sc, bank, current) -> {
        bank.setForeign(current, requestForeign(sc));
        return current;
    });

    private static final String ACCOUNT_TYPE_PROMPT = buildAccountTypePrompt();

    private final String name;
    private final InputCommand inputCommand;

    InputCommands(String name, InputCommand inputCommand) {
        this.name = name;
        this.inputCommand = inputCommand;
    }

    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        return inputCommand.execute(scanner, bank, current);
    }

    @Override
    public String toString() {
        return name;
    }

    private static boolean requestForeign(Scanner scanner) {
        System.out.print("Enter status (1-foreign, 2-domestic): ");
        int answer = scanner.nextInt();
        return answer == 1;
    }

    private static int requestAccountType(Scanner scanner) {
        System.out.print(ACCOUNT_TYPE_PROMPT);
        return scanner.nextInt();
    }

    private static String buildAccountTypePrompt() {
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
