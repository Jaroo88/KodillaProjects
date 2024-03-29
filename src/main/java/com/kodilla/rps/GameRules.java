package com.kodilla.rps;

public class GameRules {
    public static String calculateRoundResult(String playerMove, String computerMove) {
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

