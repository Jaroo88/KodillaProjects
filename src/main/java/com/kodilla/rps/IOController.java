package com.kodilla.rps;

import java.util.Scanner;

public class IOController {
    private final Scanner scanner;

    public IOController() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getPlayerInput() {
        return scanner.nextLine();
    }

    public int getPlayerInputInt() {
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}

