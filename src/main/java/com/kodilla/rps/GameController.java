package com.kodilla.rps;

import java.util.Random;

public class GameController {
    private final IOController ioController;
    private final Game game;

    public GameController(IOController ioController, Game game) {
        this.ioController = ioController;
        this.game = game;
    }

    public void playGame(Player player) {
        ioController.displayMessage("Witaj w grze Papier, Kamień, Nożyce!");
        ioController.displayMessage("Podaj swoje imię: ");
        String playerName = ioController.getPlayerInput();
        ioController.displayMessage("Podaj liczbę wygranych rund do zwycięstwa: ");
        int roundsToWin = ioController.getPlayerInputInt();

        while (!game.isGameOver()) {
            String playerMove = getPlayerMove();
            String computerMove = generateComputerMove();
            String result = GameRules.calculateRoundResult(playerMove, computerMove);
            ioController.displayMessage("Twój ruch: " + playerMove);
            ioController.displayMessage("Ruch komputera: " + computerMove);
            ioController.displayMessage(result);

            if (result.equals("Wygrałeś!")) {
                game.incrementPlayerWins();
            } else if (result.equals("Przegrałeś!")) {
                game.incrementComputerWins();
            }
        }

        displayGameResult(playerName);
        ioController.closeScanner();
    }

    private String getPlayerMove() {
        ioController.displayMessage("\nWybierz swój ruch:");
        ioController.displayMessage("1 - Kamień");
        ioController.displayMessage("2 - Papier");
        ioController.displayMessage("3 - Nożyce");
        ioController.displayMessage("x - Zakończ grę");
        ioController.displayMessage("n - Nowa gra");
        return ioController.getPlayerInput();
    }

    private String generateComputerMove() {
        Random random = new Random();
        int computerMoveNumber = random.nextInt(3) + 1;
        String computerMove;
        switch (computerMoveNumber) {
            case 1:
                computerMove = "Kamień";
                break;
            case 2:
                computerMove = "Papier";
                break;
            case 3:
                computerMove = "Nożyce";
                break;
            default:
                computerMove = "";
                break;
        }
        return computerMove;
    }

    private void displayGameResult(String playerName) {
        ioController.displayMessage("Koniec gry!");
        if (game.getPlayerWins() == game.getRoundsToWin()) {
            ioController.displayMessage("Gratulacje, " + playerName + "! Wygrałeś grę!");
        } else {
            ioController.displayMessage("Niestety, przegrałeś grę. Komputer zwyciężył.");
        }
    }
}

