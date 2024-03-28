package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {
    private static int playerWins = 0;
    private static int computerWins = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean end = false;

        System.out.println("Witaj w grze Papier, Kamień, Nożyce!");
        System.out.print("Podaj swoje imię: ");
        String playerName = scanner.nextLine();

        System.out.print("Podaj liczbę wygranych rund do zwycięstwa: ");
        int roundsToWin = scanner.nextInt();
        scanner.nextLine();

        while (!end) {
            System.out.println("\nWybierz swój ruch:");
            System.out.println("1 - Kamień");
            System.out.println("2 - Papier");
            System.out.println("3 - Nożyce");
            System.out.println("x - Zakończ grę");
            System.out.println("n - Nowa gra");

            String playerMove = scanner.nextLine();

            switch (playerMove) {
                case "1":
                    playRound(playerName, "Kamień", roundsToWin, scanner);
                    break;
                case "2":
                    playRound(playerName, "Papier", roundsToWin, scanner);
                    break;
                case "3":
                    playRound(playerName, "Nożyce", roundsToWin, scanner);
                    break;
                case "x":
                    System.out.println("Czy na pewno zakończyć grę? (T/N)");
                    String choice = scanner.nextLine().toUpperCase();
                    if (choice.equals("T")) {
                        end = true;
                        System.out.println("Do widzenia!");
                    }
                    break;
                case "n":
                    System.out.println("Czy na pewno zakończyć aktualną grę? (T/N)");
                    String restartChoice = scanner.nextLine().toUpperCase();
                    if (restartChoice.equals("T")) {
                        end = true;
                    }
                    break;
                default:
                    System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                    break;
            }

            if (playerWins == roundsToWin || computerWins == roundsToWin) {
                end = true;
                System.out.println("Koniec gry!");
                if (playerWins == roundsToWin) {
                    System.out.println("Gratulacje, " + playerName + "! Wygrałeś grę!");
                } else {
                    System.out.println("Niestety, przegrałeś grę. Komputer zwyciężył.");
                }
            }
        }

        scanner.close();
    }

    private static void playRound(String playerName, String playerMove, int roundsToWin, Scanner scanner) {
        String computerMove = generateComputerMove();
        String result = calculateRoundResult(playerMove, computerMove);

        System.out.println("Twój ruch: " + playerMove);
        System.out.println("Ruch komputera: " + computerMove);
        System.out.println(result);

        if (result.equals("Wygrałeś!")) {
            playerWins++;
        } else if (result.equals("Przegrałeś!")) {
            computerWins++;
        }
    }

    private static String generateComputerMove() {
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

    private static String calculateRoundResult(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Remis";
        } else if ((playerMove.equals("Kamień") && computerMove.equals("Nożyce")) ||
                (playerMove.equals("Papier") && computerMove.equals("Kamień")) ||
                (playerMove.equals("Nożyce") && computerMove.equals("Papier"))) {
            return "Wygrałeś!";
        } else {
            return "Przegrałeś!";
        }
    }
}