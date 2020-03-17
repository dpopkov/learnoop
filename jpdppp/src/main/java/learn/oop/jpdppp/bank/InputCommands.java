package learn.oop.jpdppp.bank;

import java.util.Scanner;

public enum InputCommands implements InputCommand {
    QUIT("quit", (sc, bank, current) -> {
        sc.close();
        System.out.println("Bye!");
        return -1;
    }),
    NEW("new", (sc, bank, current) -> {
        int type = requestType(sc);
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

    private String name;
    private InputCommand inputCommand;

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

    private static int requestType(Scanner scanner) {
        System.out.print("Enter type (1-savings, 2-checking, 3-interest checking): ");
        return scanner.nextInt();
    }
}
