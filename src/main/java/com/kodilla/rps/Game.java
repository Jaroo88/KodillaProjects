package com.kodilla.rps;

public class Game {

    private int playerWins;
    private int computerWins;

    private int roundsToWin;

    public Game(int roundsToWin) {
        this.roundsToWin = roundsToWin;
    }

    public int getRoundsToWin() {
        return roundsToWin;

    }

    public boolean isGameOver() {
        return playerWins == roundsToWin || computerWins == roundsToWin;
    }

    public void incrementPlayerWins() {
        playerWins++;
    }

    public void incrementComputerWins() {
        computerWins++;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }
}

