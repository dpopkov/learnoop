package learn.oop.jpdppp.bank;

import java.util.Scanner;

/**
 * It is responsible for I/O processing.
 */
public class BankClient {
    private final Scanner scanner;
    private final InputController controller;
    private final InputCommand[] commands = InputCommands.values();

    public BankClient(Scanner scanner, InputController controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void run() {
        final String promptMessage = constructPromptMessage();
        String response = "";
        while (!"Bye!".equals(response)) {
            System.out.print(promptMessage);
            int cmdNum = scanner.nextInt();
            if (0 <= cmdNum && cmdNum < commands.length) {
                InputCommand command = commands[cmdNum];
                response = command.execute(scanner, controller);
                System.out.println(response);
            } else {
                System.out.println("Illegal command.");
            }
        }
    }

    private String constructPromptMessage() {
        StringBuilder result = new StringBuilder("Enter command (");
        int lastCmd = commands.length - 1;
        for (int cmdNum = 0; cmdNum < lastCmd; cmdNum++) {
            result.append(cmdNum).append("=").append(commands[cmdNum]).append(", ");
        }
        result.append(lastCmd).append("=").append(commands[lastCmd]).append("): ");
        return result.toString();
    }
}
