package learn.oop.jpdppp.bank;

import java.util.Scanner;

public enum InputCommands implements InputCommand {
    QUIT("quit", (sc, controller) -> {
        sc.close();
        return "Bye!";
    }),
    NEW("new", (sc, controller) -> {
        System.out.print(controller.getAccountTypePrompt());
        int type = sc.nextInt();
        boolean foreign = requestForeign(sc);
        return controller.newCmd(type, foreign);
    }),
    SELECT("select", (sc, controller) -> {
        System.out.print("Enter account #: ");
        int newCurrent = sc.nextInt();
        return controller.selectCmd(newCurrent);
    }),
    DEPOSIT("deposit", (sc, controller) -> {
        System.out.print("Enter deposit amount: ");
        int amt = sc.nextInt();
        return controller.depositCmd(amt);
    }),
    LOAN("loan", (sc, controller) -> {
        System.out.print("Enter loan amount: ");
        int loan = sc.nextInt();
        return controller.loanCmd(loan);
    }),
    SHOW("show", (sc, controller) -> {
        return controller.showCmd();
    }),
    INTEREST("interest", (sc, controller) -> {
        return controller.interestCmd();
    }),
    SET_FOREIGN("set foreign", (sc, controller) -> {
        return controller.setForeignCmd(requestForeign(sc));
    });

    private final String name;
    private final InputCommand inputCommand;

    InputCommands(String name, InputCommand inputCommand) {
        this.name = name;
        this.inputCommand = inputCommand;
    }

    @Override
    public String execute(Scanner scanner, InputController controller) {
        return inputCommand.execute(scanner, controller);
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
}
